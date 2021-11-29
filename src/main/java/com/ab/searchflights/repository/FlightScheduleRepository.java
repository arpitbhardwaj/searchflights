package com.ab.searchflights.repository;

import com.ab.searchflights.model.FlightMap;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository {
    FlightMap readFlightSchedule();
}
