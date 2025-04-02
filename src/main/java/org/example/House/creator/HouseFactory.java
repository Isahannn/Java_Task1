package org.example.House.creator;

import org.example.House.entity.House;
import org.example.House.validator.Validator;
import java.util.Optional;

public class HouseFactory {
    private final Validator<House> validator;

    public HouseFactory(Validator<House> validator) {
        this.validator = validator;
    }

    public Optional<House> createHouse(long id, int apartmentNumber,
                                       double area, int floor, int rooms,
                                       String street, String buildingType,
                                       int serviceLife) {
        House house = new House(id, apartmentNumber, area, floor,
                rooms, street, buildingType, serviceLife);
        return validator.validate(house) ? Optional.of(house) : Optional.empty();
    }
}