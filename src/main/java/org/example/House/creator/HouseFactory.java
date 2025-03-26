package org.example.House.creator;

import org.example.House.entity.House;
import org.example.House.Validator.HouseValidator;

import java.util.Optional;

public class HouseFactory {

    public static Optional<House> createHouse(long id, int apartmentNumber,
                                              double area, int floor, int numberOfRooms,
                                              String street, String buildingType,
                                              int serviceLife) {
        // Проверяем параметры до создания объекта
        if (HouseValidator.validateHouseParameters(id, numberOfRooms, area, floor, street, buildingType, serviceLife)) {
            // Если параметры корректны, создаем объект House
            House house = new House(id, apartmentNumber, area, floor, numberOfRooms, street, buildingType, serviceLife);
            return Optional.of(house);
        } else {
            // Если параметры некорректны, возвращаем Optional.empty()
            return Optional.empty();
        }
    }
}