package org.example.house.repository;

import org.example.house.entity.House;
import java.util.ArrayList;
import java.util.List;

public class HouseRepository {
    private final List<House> houses = new ArrayList<>();

    public List<House> getAllHouses() {
        return new ArrayList<>(houses);
    }

    public boolean addHouse(House house) {
        if (!houses.contains(house)) {
            houses.add(house);
            return true;
        }
        return false;
    }

    public boolean removeHouse(House house) {
        return houses.remove(house);
    }
}