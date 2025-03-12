package org.example.creator;

import org.example.entity.House;
import org.example.Validator.HouseValidator; // Импортируем HouseValidator
import org.example.Validator.Validator;
import java.util.Optional;

public class HouseFactory {
    public static Optional<House> createHouse(long id, int apartmentNumber,
                                              double area, int floor, int numberOfRooms,
                                              String street, String buildingType,
                                              int serviceLife) {
        House house = new House(id, apartmentNumber, area, floor,
                numberOfRooms, street, buildingType, serviceLife);

        // Создаем экземпляр HouseValidator
        Validator<House> validator = new HouseValidator();

        // Проверяем валидность дома
        return validator.validate(house)
                ? Optional.of(house)
                : Optional.empty();
    }
}