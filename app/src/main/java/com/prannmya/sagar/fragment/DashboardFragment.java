package com.prannmya.sagar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.prannmya.sagar.R;
import com.prannmya.sagar.activity.MainActivity;
import com.prannmya.sagar.adapter.CustomAdapter;
import com.prannmya.sagar.adapter.GridAdapter;
import com.prannmya.sagar.utils.AutoScrollViewPager;
import com.prannmya.sagar.utils.Constant;
import com.prannmya.sagar.utils.LogUtils;
import com.prannmya.sagar.vo.Category;
import com.prannmya.sagar.vo.GridItems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.prannmya.sagar.utils.Constant.DASHBORD_CONTENT;
import static com.prannmya.sagar.utils.Constant.DASHBORD_ICON;


/***
 * @author Deepak
 */
@SuppressWarnings("ALL")
public class DashboardFragment extends GuruJIFragment {
    private static Constant constant;

    Integer[] imageId = {R.drawable.dashboard1, R.drawable.dashboard2, R.drawable.dashboard3, R.drawable.dashboard4, R.drawable.dashboad5};
    String[] imagesName = {"image1", "image2", "image3", "image4", "image5"};
    GridItems[] gridItems = {};

    Timer timer;
    @BindView(R.id.vp_event)
    public AutoScrollViewPager viewPager;
    private GridView mGridView;
    private GridAdapter mGridAdapter;
    /**
     * Class constructor
     **/
    public DashboardFragment() {
        super();
    }

    /**
     * initilize ui content
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try {
            view = inflater.inflate(R.layout.fragment_dashboard, container, false);
            ButterKnife.bind(this, view);
            eventActivity = ((MainActivity) getActivity());
            fragmentManager = getActivity().getSupportFragmentManager();
            viewPager.startAutoScroll();
            viewPager.setInterval(3000);
            viewPager.setCycle(true);
            viewPager.setStopScrollWhenTouch(true);
            PagerAdapter adapter = new CustomAdapter(eventActivity,imageId,imagesName);
            viewPager.setAdapter(adapter);
            mGridView = (GridView) view.findViewById(R.id.gv_dashboard);
            setGridItem();
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
        return view;
    }


    /**
     * onResume is call resume of parent activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (getView() != null) {
            getView().setFocusableInTouchMode(true);
            getView().requestFocus();
            getView().setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v1, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
                    }
                    return true;
                }
            });
        }
    }


    @Override
    public void onAttach(Context cntxt) {
        super.onAttach(cntxt);
        this.context = cntxt;
    }
    private void setGridItem() {
        try {
            ArrayList<String> arrayTitle = new ArrayList<String>();
            ArrayList<Integer> arrayIcon = new ArrayList<Integer>();
            Category m = new Category();
            for (int i = 0; i < DASHBORD_CONTENT.length; i++) {
                arrayTitle.add(i, DASHBORD_CONTENT[i]);
                arrayIcon.add(i, DASHBORD_ICON[i]);
            }
            Iterator<String> it = arrayTitle.iterator();
            Iterator<Integer> icon = arrayIcon.iterator();
            while (it.hasNext()) {
                ArrayList<GridItems> itmLst = new ArrayList<GridItems>();
                for (int i = 0; i < 12; i++) {
                    if (it.hasNext()) {
                        GridItems itm1 = new GridItems(i, it.next(), icon.next());
                        itmLst.add(itm1);
                    } else {
                        break;
                    }
                }
                GridItems[] gp = {};
                gridItems = itmLst.toArray(gp);
                mGridAdapter = new GridAdapter(eventActivity, gridItems);
                if (mGridView != null) {
                    mGridView.setAdapter(mGridAdapter);
                }
            }
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                }
            });
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }

}
