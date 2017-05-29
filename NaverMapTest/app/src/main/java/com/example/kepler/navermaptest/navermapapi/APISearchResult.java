package com.example.kepler.navermaptest.navermapapi;

import java.util.List;

/**
 * Created by Kepler on 2017-05-16.
 */

public class APISearchResult {
    String lastBuildDate;
    int total;
    int start;
    int display;
    List<Item> items;

    class Item{
        String title;
        String link;
        String telephone;
        String address;
        String roadAddress;
        int mapx;
        int mapy;

    }
}
