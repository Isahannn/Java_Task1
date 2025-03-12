package org.example.creator;
//optional for factory
import org.example.entity.House;
import org.example.Validator.Validator;

public class HouseFactory {
    public static House createHouse(long id, int apartmentNumber, double area, int floor, int numberOfRooms, String street, String buildingType, int serviceLife) {
        House house = new House(id, apartmentNumber, area, floor, numberOfRooms, street, buildingType, serviceLife);
        if (Validator.validate(house)) {
            return house;
        } else {
            throw new IllegalArgumentException("Invalid house data");
        }
    }
}