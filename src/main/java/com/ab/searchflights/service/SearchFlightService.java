package com.ab.searchflights.service;

import com.ab.searchflights.model.SearchResult;
import org.springframework.stereotype.Service;

@Service
public interface SearchFlightService {
    SearchResult searchFlights(String sourceCity, String destCity, int noOfOptions);
}
