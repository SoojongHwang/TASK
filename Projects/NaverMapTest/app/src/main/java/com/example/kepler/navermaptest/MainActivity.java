package com.example.kepler.navermaptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kepler.navermaptest.navermapapi.MapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    final static String url = "https://openapi.naver.com/v1/map/staticmap.bin?" +
            "clientId=hOBAjjmz9dUkwoGrp6pS&url=http://naver.com&crs=EPSG:4326&center=127.1052133,37.3595316&level=11" +
            "&w=600&h=600&&baselayer=default&level=11&markers=127.1052133,37.3595316";

    @BindView(R.id.bitmap)
    ImageView bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_add_map)
    public void onClickedAddButton(){
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_add_photo)
    public void onClickedAddStaticMap(){
        Glide.with(this).load(url).into(bitmap);
    }
}
