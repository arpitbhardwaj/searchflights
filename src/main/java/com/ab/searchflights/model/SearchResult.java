package com.ab.searchflights.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchResult {
    List<Map<String, Map<String, Integer>>> result = new ArrayList<>();

    public SearchResult(List<Route> routeList) {

    }

    public List<Map<String, Map<String, Integer>>> getResult() {
        return result;
    }
}
