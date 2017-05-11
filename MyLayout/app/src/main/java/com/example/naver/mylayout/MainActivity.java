package com.example.naver.mylayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean mode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!mode) {
            setContentView(R.layout.main);
        } else {
            MyLayout ml = new MyLayout(this);
            ml.setWeightSum(4);

            TextView tv1 = new TextView(this);
            MyLayout.LayoutParams lp1 = new MyLayout.LayoutParams(100, ViewGroup.LayoutParams.MATCH_PARENT);
            tv1.setText("Android");
            tv1.setBackgroundColor(Color.RED);
            tv1.setTextSize(20);
            tv1.setGravity(Gravity.CENTER_HORIZONTAL);
            tv1.setLayoutParams(lp1);

            TextView tv2 = new TextView(this);
            MyLayout.LayoutParams lp2 = new MyLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            tv2.setText("Hello");
            tv2.setBackgroundColor(Color.GREEN);
            tv2.setTextSize(20);
            tv2.setGravity(Gravity.CENTER_HORIZONTAL);
            lp2.setWeight(1.0f);
            tv2.setLayoutParams(lp2);

            TextView tv3 = new TextView(this);
            MyLayout.LayoutParams lp3 = new MyLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            tv3.setText("World");
            tv3.setBackgroundColor(Color.YELLOW);
            tv3.setTextSize(20);
            tv3.setGravity(Gravity.CENTER_HORIZONTAL);
            lp3.setWeight(3.0f);
            tv3.setLayoutParams(lp3);

            ml.addView(tv1);
            ml.addView(tv2);
            ml.addView(tv3);

            setContentView(ml);

        }
    }
}