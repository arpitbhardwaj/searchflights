package com.ab.searchflights.model;

public class Route implements Comparable<Route>{

    int duration;

    @Override
    public int compareTo(Route route) {
        return this.duration - route.duration;
    }
}
