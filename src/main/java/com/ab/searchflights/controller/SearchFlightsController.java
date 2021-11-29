package com.ab.searchflights.controller;


import com.ab.searchflights.model.SearchResult;
import com.ab.searchflights.service.SearchFlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/searchflights")
public class SearchFlightsController {

    private SearchFlightService service;

    @GetMapping("/{sourceCity}/{destCity}/{options}")
    List<Map<String, Map<String, Integer>>> searchFlights(@PathVariable String sourceCity, @PathVariable String destCity, @PathVariable int options){
       return service.searchFlights(sourceCity,destCity,options).getResult();
    }
}
