package org.example.House.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.House.entity.House;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseServiceImpl implements HouseService {
    private static final Logger logger = LogManager.getLogger(HouseServiceImpl.class);

    private final List<House> houses = new ArrayList<>();

    @Override
    public void addHouse(House house) {
        if (house == null) {
            logger.warn("Attempt to add null house object!");
            return;
        }

        if (houses.contains(house)) {
            logger.warn("Attempt to add duplicate house: {}", house);
            return;
        }

        logger.info("Adding house: {}", house);
        houses.add(house);
    }

    @Override
    public void removeHouse(House house) {
        if (house == null) {
            logger.warn("Attempt to remove null house object!");
            return;
        }

        boolean isRemoved = houses.remove(house);
        if (isRemoved) {
            logger.info("House removed: {}", house);
        } else {
            logger.warn("House not found: {}", house);
        }
    }

    @Override
    public List<House> findAllHouses() {
        logger.info("Retrieving all houses");
        return new ArrayList<>(houses);
    }

    @Override
    public List<House> findHousesWithRooms(int rooms) {
        logger.info("Searching for houses with {} rooms", rooms);
        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor) {
        logger.info("Searching for houses with {} rooms and floors between {} and {}", rooms, minFloor, maxFloor);

        if (minFloor > maxFloor) {
            logger.warn("Invalid floor range: minFloor ({}) > maxFloor ({})", minFloor, maxFloor);
            return new ArrayList<>();
        }

        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms &&
                        house.getFloor() >= minFloor &&
                        house.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithAreaGreaterThan(double area) {
        logger.info("Searching for houses with area greater than {}", area);
        return houses.stream()
                .filter(house -> house.getArea() > area)
                .collect(Collectors.toList());
    }
}