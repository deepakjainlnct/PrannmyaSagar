package com.prannmya.sagar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prannmya.sagar.R;
import com.prannmya.sagar.vo.GridItems;


/**
 * Created by Deepak on 11-12-2017.
 */

public class GridAdapter extends BaseAdapter {
    Context context;

    public class ViewHolder {
        public ImageView imageView;
        public TextView textTitle;
    }

    private GridItems[] items;
    private LayoutInflater mInflater;

    public GridAdapter(Context context, GridItems[] locations) {
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        items = locations;

    }

    public GridItems[] getItems() {
        return items;
    }

    public void setItems(GridItems[] items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        if (items != null) {
            return items.length;
        }
        return 0;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        if (items != null && position >= 0 && position < getCount()) {
            return items[position];
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (items != null && position >= 0 && position < getCount()) {
            return items[position].id;
        }
        return 0;
    }

    public void setItemsList(GridItems[] locations) {
        this.items = locations;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.dashboard_grid_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view
                    .findViewById(R.id.grid_item_image);
            viewHolder.textTitle = (TextView) view
                    .findViewById(R.id.grid_item_label);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GridItems gridItems = items[position];
        setCatImage(position, viewHolder, gridItems);
        return view;
    }

    private void setCatImage(int pos, ViewHolder viewHolder, GridItems catTitle) {
        viewHolder.imageView.setImageResource(catTitle.drawable);
        viewHolder.textTitle.setText(catTitle.title);
    }
}
