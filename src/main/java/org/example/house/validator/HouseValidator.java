package org.example.house.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.house.entity.House;

import java.util.function.Predicate;

public class HouseValidator implements Validator<House> {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);
    private boolean isValid = true;

    @Override
    public boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            return false;
        }

        check(house.getId(), "ID", v -> v > 0);
        check(house.getNumberOfRooms(), "Number of rooms", v -> v > 0);
        check(house.getArea(), "Area", v -> v > 0);
        check(house.getFloor(), "Floor", v -> v > 0);
        check(house.getStreet(), "Street", v -> v != null && !v.trim().isEmpty());
        check(house.getBuildingType(), "Building type", v -> v != null && !v.trim().isEmpty());
        check(house.getServiceLife(), "Service life", v -> v > 0);

        return isValid;
    }

    private <T> void check(T value, String fieldName, Predicate<T> validator) {
        if (!validator.test(value)) {
            logger.error("Invalid {}: {}", fieldName, value);
            isValid = false;
        }
    }
}