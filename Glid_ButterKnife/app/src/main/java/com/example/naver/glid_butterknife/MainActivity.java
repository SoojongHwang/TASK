package com.example.naver.glid_butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    static final String url = "https://lh3.googleusercontent.com/DjUgn0hqwzO0hw4NchiE4r66I5vutBFZQWsL0nct8gFTkzRhBIAZmyXPdtyzD4-hKGM=w300";
    @BindView(R.id.iv) ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Glide.with(this).load(url).into(iv);


    }

    @OnClick(R.id.iv)
    public void onClicked(){
        Toast.makeText(getApplicationContext(), "haha", Toast.LENGTH_SHORT).show();
    }
}
