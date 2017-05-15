package com.example.kepler.navermaptest;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MapActivity extends NMapActivity {
    InputMethodManager imm;

    @BindView(R.id.nmapview)
    NMapView mMapView;
    @BindView(R.id.address)
    EditText here;
    @BindView(R.id.search)
    Button searchButton;
    @BindView(R.id.listview)
    ListView listView;

    SiteAdapter adapter;

    private final String ApiClient = "hOBAjjmz9dUkwoGrp6pS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        init();
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


    }
    private void init(){
        mMapView.setClientId(ApiClient);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();
        mMapView.setBuiltInZoomControls(true, null);
        //
        adapter = new SiteAdapter();
    }
    @OnClick(R.id.search)
    public void onClickedSearch() {
        hideKeyboard();
        Retrofit client = new Retrofit.Builder().baseUrl("https://openapi.naver.com/").addConverterFactory(GsonConverterFactory.create()).build();
        NaverAPI service = client.create(NaverAPI.class);
        Call<APIMapResult> call = service.getMap("대학로", "utf-8");


        call.enqueue(new Callback<APIMapResult>() {
            @Override
            public void onResponse(Call<APIMapResult> call, Response<APIMapResult> response) {
                if(response.isSuccessful()) {
                    List<APIMapResult.Result.Items> list = response.body().getResult().getItems();
                    for(int i=0; i<list.size(); i++){
                        String address = list.get(i).getAddress();
                        float x = list.get(i).getPoint().getX();
                        float y = list.get(i).getPoint().getY();

                        Site s = new Site(address,x,y);
                        adapter.addSite(s);
                    }
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<APIMapResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hideKeyboard(){
        imm.hideSoftInputFromWindow(here.getWindowToken(),0);
    }


    class SiteAdapter extends BaseAdapter{
        ArrayList<Site> items = new ArrayList<>();
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SiteItemView view = new SiteItemView(getApplicationContext());
            Site site = items.get(position);
            view.setAddress(site.getAddress());
            return view;
        }

        public void addSite(Site site){
            items.add(site);
        }
    }
}
