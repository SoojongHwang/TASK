package com.example.kepler.navermaptest;

/**
 * Created by Kepler on 2017-05-16.
 */

public class Site {
    final private String address;
    final private float x,y;

    public Site(String address, float x, float y) {
        this.address = address;
        this.x = x;
        this.y = y;
    }

    public String getAddress() {
        return address;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
