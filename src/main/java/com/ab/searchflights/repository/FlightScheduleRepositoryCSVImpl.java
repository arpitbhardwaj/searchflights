package com.ab.searchflights.repository;

import com.ab.searchflights.model.Flight;
import com.ab.searchflights.model.FlightMap;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Repository
public class FlightScheduleRepositoryCSVImpl implements FlightScheduleRepository {

    @Value("${flight.schedule.csvPath}")
    String csvPath;

    @Override
    public FlightMap readFlightSchedule() {

        FlightMap flightMap = new FlightMap();

        File file = new File(csvPath);
        try (FileReader fileReader = new FileReader(file); CSVReader csvReader = new CSVReader(fileReader)){
            String[] nextRow = null;
            while ((nextRow = csvReader.readNext()) != null){
                String flightNo = nextRow[0];
                String srcCity = nextRow[1];
                String destCity = nextRow[2];
                String startTime = nextRow[3];
                String endTime = nextRow[4];
                System.out.println(flightNo+"-"+srcCity+"-"+destCity+"-"+startTime+"-"+endTime);
                Flight flight = new Flight(flightNo,srcCity,destCity,startTime,endTime);
                flightMap.addFlight(srcCity,flight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return flightMap;
    }
}
