package com.example.kepler.navermaptest;

import android.os.Bundle;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapActivity extends NMapActivity {
    @BindView(R.id.nmapview)
    NMapView mMapView;

    private final String ApiClient = "hOBAjjmz9dUkwoGrp6pS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        init();

    }
    private void init(){
        mMapView.setClientId(ApiClient);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
    }
    @OnClick(R.id.search)
    public void onClickedSearch(){
        Toast.makeText(getApplicationContext(), "주소찾기", Toast.LENGTH_SHORT).show();
    }
}
