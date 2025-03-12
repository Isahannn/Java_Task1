package org.example.service;
//interface for validator and service
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.House;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseService {
    private static final Logger logger = LogManager.getLogger(HouseService.class);
    private final List<House> houses = new ArrayList<>(); // Internal state

    public void addHouse(House house) {
        logger.info("Adding house: {}", house);
        if (house != null) {
            houses.add(house);
        }
    }

    public List<House> getHousesWithRooms(int rooms) {
        logger.info("Searching for houses with {} rooms", rooms);
        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms)
                .collect(Collectors.toList());
    }

    public List<House> getHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor) {
        logger.info("Searching for houses with {} rooms and floor between {} and {}", rooms, minFloor, maxFloor);
        if (minFloor > maxFloor) {
            logger.warn("Invalid floor range: minFloor ({}) > maxFloor ({})", minFloor, maxFloor);
            return new ArrayList<>();
        }
        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    public List<House> getHousesWithAreaGreaterThan(double area) {
        logger.info("Searching for houses with area greater than {}", area);
        return houses.stream()
                .filter(house -> house.getArea() > area)
                .collect(Collectors.toList());
    }
}