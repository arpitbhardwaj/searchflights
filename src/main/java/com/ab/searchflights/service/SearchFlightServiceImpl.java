package com.ab.searchflights.service;

import com.ab.searchflights.model.Flight;
import com.ab.searchflights.model.FlightMap;
import com.ab.searchflights.model.Route;
import com.ab.searchflights.model.SearchResult;
import com.ab.searchflights.repository.FlightScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class SearchFlightServiceImpl implements SearchFlightService{

    @Value("${flight.min-layover}")
    int minLayover;

    @Value("${flight.max-layover}")
    int maxLayover;

    @Autowired
    FlightScheduleRepository repository;

    FlightMap flightMap;

    public SearchFlightServiceImpl(FlightMap flightMap) {
        this.flightMap = repository.readFlightSchedule();
    }

    @Override
    public SearchResult searchFlights(String sourceCity, String destCity, int noOfOptions) {
        if(!isValidCity(sourceCity) || !isValidCity(destCity)){
            throw new IllegalArgumentException("Invalid City");
        }
        SearchResult result = searchFastestRoutes(flightMap.getFlightMap(), sourceCity,destCity,noOfOptions);
        return result;
    }

    private boolean isValidCity(String city) {
        return flightMap.getFlightMap().keySet().contains(city);
    }

    private SearchResult searchFastestRoutes(Map<String, List<Flight>> flightMap, String sourceCity, String destCity, int noOfOptions) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        List<Flight> flights = flightMap.get(sourceCity);
        return null;
    }
}
