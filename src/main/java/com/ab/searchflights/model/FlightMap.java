package com.ab.searchflights.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightMap {
    Map<String, List<Flight>> flightMap = new HashMap<>();

    public boolean addFlight(String sourceCity, Flight f){
        if (flightMap.containsKey(sourceCity)){
            flightMap.get(sourceCity).add(f);
        }else {
            List<Flight> flights = new ArrayList<>();
            flights.add(f);
            flightMap.put(sourceCity,flights);
        }
        return true;
    }

    public Map<String, List<Flight>> getFlightMap() {
        return flightMap;
    }
}
