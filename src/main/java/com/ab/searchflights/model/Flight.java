package com.ab.searchflights.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Flight {
    String flightNo;
    String sourceCity;
    String destinationCity;
    String startTime;
    String endTime;
    long duration;

    public Flight(String flightNo, String sourceCity, String destinationCity, String startTime, String endTime) {
        this.flightNo = flightNo;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.startTime = startTime;
        this.endTime = endTime;

        LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime end = LocalTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_TIME);
        this.duration = Duration.between(start,end).get(ChronoUnit.MINUTES);
    }
}
