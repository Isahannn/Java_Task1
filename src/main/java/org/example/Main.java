package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.House.entity.House;
import org.example.House.service.HouseService;
import org.example.House.service.HouseServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private final List<House> houses = new ArrayList<>();
    //узнать
    public static void main(String[] args) {
        logger.info("Starting the application.");

        // Create the service
        HouseService houseService = new HouseServiceImpl();

        // Add houses to the service
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));
        houseService.addHouse(new House(3, 303, 90.0, 7, 3, "Third Street", "Apartment", 20));

        // Search for houses with 3 rooms
        logger.info("Searching for houses with 3 rooms:");
        List<House> housesWith3Rooms = houseService.findHousesWithRooms(3);
        housesWith3Rooms.forEach(house -> logger.info(house.toString()));

        // Search for houses with 3 rooms and floor between 4 and 8
        logger.info("Searching for houses with 3 rooms and floor between 4 and 8:");
        List<House> housesWith3RoomsAndFloorRange = houseService.findHousesWithRoomsAndFloorRange(3, 4, 8);
        housesWith3RoomsAndFloorRange.forEach(house -> logger.info(house.toString()));

        // Search for houses with an area greater than 70
        logger.info("Searching for houses with area greater than 70:");
        List<House> housesWithAreaGreaterThan70 = houseService.findHousesWithAreaGreaterThan(70);
        housesWithAreaGreaterThan70.forEach(house -> logger.info(house.toString()));

        logger.info("Application finished.");
    }
}