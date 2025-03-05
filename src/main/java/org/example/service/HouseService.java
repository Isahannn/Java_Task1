package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.House;

import java.util.ArrayList;
import java.util.List;

// не хранить массив тут епта
public class HouseService {
    private static final Logger logger = LogManager.getLogger(HouseService.class);
    private List<House> houses;

    public HouseService() {
        this.houses = new ArrayList<>();
        logger.debug("HouseService initialized.");
    }

    public void addHouse(House house) {
        if (house != null) {
            houses.add(house);
            logger.info("House added: {}", house);
        } else {
            logger.warn("Attempted to add a null house.");
        }
    }

    public List<House> getHousesWithRooms(int numberOfRooms) {
        logger.debug("Searching for houses with {} rooms.", numberOfRooms);
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms) {
                result.add(house);
            }
        }
        logger.info("Found {} houses with {} rooms.", result.size(), numberOfRooms);
        return result;
    }

    public List<House> getHousesWithRoomsAndFloorRange(int numberOfRooms, int minFloor, int maxFloor) {
        logger.debug("Searching for houses with {} rooms and floor between {} and {}.", numberOfRooms, minFloor, maxFloor);
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                result.add(house);
            }
        }
        logger.info("Found {} houses with {} rooms and floor between {} and {}.", result.size(), numberOfRooms, minFloor, maxFloor);
        return result;
    }

    public List<House> getHousesWithAreaGreaterThan(double area) {
        logger.debug("Searching for houses with area greater than {}.", area);
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getArea() > area) {
                result.add(house);
            }
        }
        logger.info("Found {} houses with area greater than {}.", result.size(), area);
        return result;
    }
}