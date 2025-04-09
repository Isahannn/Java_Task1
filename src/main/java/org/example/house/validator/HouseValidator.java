package org.example.house.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.house.entity.House;

import java.util.function.Predicate;

public class HouseValidator implements Validator<House> {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);

    @Override
    public boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            throw new IllegalArgumentException("House object cannot be null");
        }

        validateField(house.getNumberOfRooms(), "Number of rooms", v -> v > 0);
        validateField(house.getArea(), "Area", v -> v > 0);
        validateField(house.getFloor(), "Floor", v -> v > 0);
        validateField(house.getStreet(), "Street", v -> v != null && !v.isBlank());
        validateField(house.getBuildingType(), "Building type", v -> v != null && !v.isBlank());
        validateField(house.getServiceLife(), "Service life", v -> v > 0);

        return true;
    }

    private <T> void validateField(T value, String fieldName, Predicate<T> validator) {
        if (!validator.test(value)) {
            logger.error("Invalid {}: {}", fieldName, value);
            throw new IllegalArgumentException(fieldName + " is invalid: " + value);
        }
    }
}