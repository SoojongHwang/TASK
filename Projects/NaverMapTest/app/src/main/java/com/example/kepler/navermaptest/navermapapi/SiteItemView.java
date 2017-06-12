package com.example.kepler.navermaptest.navermapapi;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kepler.navermaptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kepler on 2017-05-16.
 */

public class SiteItemView extends LinearLayout {
    @BindView(R.id.item_address)
    TextView tv;

    @BindView(R.id.item_add)
    Button bt;

    public SiteItemView(Context c) {
        super(c);
        init(c);
    }

    public SiteItemView(Context c, @Nullable AttributeSet attrs) {
        super(c, attrs);
        init(c);
    }

    private void init(Context c){
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.address_item, this, true);

        ButterKnife.bind(this);
    }

    public void setAddress(String address){
        tv.setText(address);
    }

    @OnClick(R.id.item_add)
    public void onClickedAdd(){
        Toast.makeText(getContext(), "이거 진짜 추가?", Toast.LENGTH_SHORT).show();
    }
}
