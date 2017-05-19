package com.example.kepler.navermaptest.component;

/**
 * Created by Kepler on 2017-05-19.
 */

public abstract class Component {
    public enum Type {
        TEXT, IMAGE, MAP
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;
    private int index;

}
