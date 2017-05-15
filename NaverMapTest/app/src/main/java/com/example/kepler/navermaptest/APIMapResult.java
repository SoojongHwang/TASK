package com.example.kepler.navermaptest;

import java.util.List;

/**
 * Created by Kepler on 2017-05-15.
 */

public class APIMapResult {
    private Result result;

    public Result getResult() {
        return result;
    }

    class Result {
        private int total;
        private String userquery;
        private List<Items> items;

        public List<Items> getItems() {
            return items;
        }

        class Items {
            private String address;
            private AddrDetail addrdetail;
            private boolean isRoadAddress;
            private Point point;

            class AddrDetail {
                private String country;
            }

            class Point {
                private float x;
                private float y;

                public float getX() {
                    return x;
                }

                public float getY() {
                    return y;
                }
            }

            public String getAddress() {
                return address;
            }

            public Point getPoint() {
                return point;
            }
        }
    }
}
