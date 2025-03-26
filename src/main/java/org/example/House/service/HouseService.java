package org.example.House.service;

import org.example.House.entity.House;

import java.util.List;


public interface HouseService {
    void addHouse(House house);
    void removeHouse(House house);
    List<House> findAllHouses();
    List<House> findHousesWithRooms(int rooms);
    List<House> findHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor);
    List<House> findHousesWithAreaGreaterThan(double area);
}