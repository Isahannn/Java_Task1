package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.House;
import org.example.creator.HouseFactory;
import org.example.service.HouseService;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting the application.");

        HouseService houseService = new HouseService();

        House house1 = HouseFactory.createHouse(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10);
        House house2 = HouseFactory.createHouse(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15);
        House house3 = HouseFactory.createHouse(3, 303, 90.0, 7, 3, "Third Street", "Apartment", 20);

        houseService.addHouse(house1);
        houseService.addHouse(house2);
        houseService.addHouse(house3);

        logger.info("Searching for houses with 3 rooms:");
        houseService.getHousesWithRooms(3).forEach(house -> logger.info(house.toString()));

        logger.info("Searching for houses with 3 rooms and floor between 4 and 8:");
        houseService.getHousesWithRoomsAndFloorRange(3, 4, 8).forEach(house -> logger.info(house.toString()));

        logger.info("Searching for houses with area greater than 70:");
        houseService.getHousesWithAreaGreaterThan(70).forEach(house -> logger.info(house.toString()));

        logger.info("Application finished.");
    }
}