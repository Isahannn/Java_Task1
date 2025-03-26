package org.example.House.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.House.entity.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HouseServiceImpl implements HouseService {
    private static final Logger logger = LogManager.getLogger(HouseServiceImpl.class);
    private final List<House> houses = new ArrayList<>();

    @Override
    public void addHouse(House house) {
        Optional.ofNullable(house).ifPresentOrElse(
                h -> {
                    if (!houses.contains(h)) {
                        houses.add(h);
                        logger.info("House added: {}", h);
                    } else {
                        logger.warn("Duplicate house: {}", h);
                    }
                },
                () -> logger.warn("Attempt to add null house")
        );
    }

    @Override
    public void removeHouse(House house) {
        Optional.ofNullable(house).ifPresent(h -> {
            boolean removed = houses.remove(h);
            if (removed) {
                logger.info("House removed: {}", h);
            } else {
                logger.warn("House not found: {}", h);
            }
        });
    }

    @Override
    public List<House> findAllHouses() {
        return new ArrayList<>(houses);
    }

    // Старые реализации
    @Override
    public List<House> findHousesWithRooms(int rooms) {
        return houses.stream()
                .filter(h -> h.getNumberOfRooms() == rooms)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor) {
        if (minFloor > maxFloor) {
            return List.of();
        }
        return houses.stream()
                .filter(h -> h.getNumberOfRooms() == rooms &&
                        h.getFloor() >= minFloor &&
                        h.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithAreaGreaterThan(double area) {
        return houses.stream()
                .filter(h -> h.getArea() > area)
                .collect(Collectors.toList());
    }

    // Новые методы с Optional
    @Override
    public Optional<House> findHouseById(int id) {
        return houses.stream()
                .filter(h -> h.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<List<House>> findHousesWithRoomsOptional(int rooms) {
        List<House> result = findHousesWithRooms(rooms);
        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }

    @Override
    public Optional<List<House>> findHousesWithAreaGreaterThanOptional(double area) {
        List<House> result = findHousesWithAreaGreaterThan(area);
        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }

    @Override
    public Optional<List<House>> findHousesWithRoomsAndFloorRangeOptional(int rooms, int minFloor, int maxFloor) {
        List<House> result = findHousesWithRoomsAndFloorRange(rooms, minFloor, maxFloor);
        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }
}