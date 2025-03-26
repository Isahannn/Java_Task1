package org.example.House.service;

import org.example.House.entity.House;
import java.util.List;
import java.util.Optional;

public interface HouseService {
    void addHouse(House house);
    void removeHouse(House house);
    List<House> findAllHouses();
    List<House> findHousesWithRooms(int rooms);
    List<House> findHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor);
    List<House> findHousesWithAreaGreaterThan(double area);

    Optional<House> findHouseById(int id);
    Optional<List<House>> findHousesWithRoomsOptional(int rooms);
    Optional<List<House>> findHousesWithAreaGreaterThanOptional(double area);
    Optional<List<House>> findHousesWithRoomsAndFloorRangeOptional(int rooms, int minFloor, int maxFloor);
}