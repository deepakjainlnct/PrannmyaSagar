package com.prannmya.sagar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.prannmya.sagar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBackgorund;
    static ImageCountDown countDownTimer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ButterKnife.bind(this);
        countDownTimer = new ImageCountDown(8000, 1000);
        countDownTimer.start();
    }

    class ImageCountDown extends CountDownTimer {

        public ImageCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            try {
                int timeElapsed = (int) (millisUntilFinished / 1000);
                Log.d("Time", "Time" + timeElapsed);
                if (timeElapsed == 6) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b00));
                } else if (timeElapsed == 5) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b02));
                } else if (timeElapsed == 4) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b03));
                } else if (timeElapsed == 3) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b04));
                } else if (timeElapsed == 2) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b05));
                } else if (timeElapsed == 1) {
                    ivBackgorund.setBackground(context.getResources().getDrawable(R.drawable.b01));
                }
            } catch (Exception e) {
            }
        }

        @Override
        public void onFinish() {
            try {
                final Intent intent = new Intent(context, GuguJIActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        }
    }

}
