

package org.example.house.service;

import org.example.house.entity.House;
import org.example.house.repository.HouseRepository;
import org.example.house.utils.HouseLogger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository = new HouseRepository();

    @Override
    public void addHouse(House house) {
        Optional.ofNullable(house).ifPresentOrElse(
                h -> {
                    if (houseRepository.addHouse(h)) {
                        HouseLogger.getLogger().info("House added: {}", h);
                    } else {
                        HouseLogger.getLogger().warn("Duplicate house: {}", h);
                    }
                },
                () -> HouseLogger.getLogger().warn("Attempt to add null house")
        );
    }

    @Override
    public void removeHouse(House house) {
        Optional.ofNullable(house).ifPresent(h -> {
            boolean removed = houseRepository.removeHouse(h);
            if (removed) {
                HouseLogger.getLogger().info("House removed: {}", h);
            } else {
                HouseLogger.getLogger().warn("House not found: {}", h);
            }
        });
    }

    @Override
    public List<House> findAllHouses() {
        return houseRepository.getAllHouses();
    }

    @Override
    public List<House> findHousesWithRooms(int rooms) {
        return houseRepository.getAllHouses().stream()
                .filter(h -> h.getNumberOfRooms() == rooms)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor) {
        if (minFloor > maxFloor) {
            return List.of();
        }
        return houseRepository.getAllHouses().stream()
                .filter(h -> h.getNumberOfRooms() == rooms &&
                        h.getFloor() >= minFloor &&
                        h.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    @Override
    public List<House> findHousesWithAreaGreaterThan(double area) {
        return houseRepository.getAllHouses().stream()
                .filter(h -> h.getArea() > area)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<House> findHouseById(int id) {
        return houseRepository.getAllHouses().stream()
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