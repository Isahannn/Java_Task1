package org.example.house.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.house.entity.House;

import java.util.function.Predicate;

public final class HouseValidator implements Validator<House> {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);
    private static final Predicate<String> NOT_BLANK = v -> v != null && !v.isBlank();
    private static final Predicate<Number> POSITIVE = v -> v != null && v.doubleValue() > 0;

    @Override
    public boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            throw new IllegalArgumentException("House object cannot be null");
        }

        validateField(house.getNumberOfRooms(), "Number of rooms", POSITIVE);
        validateField(house.getArea(), "Area", POSITIVE);
        validateField(house.getFloor(), "Floor", POSITIVE);
        validateField(house.getStreet(), "Street", NOT_BLANK);
        validateField(house.getBuildingType(), "Building type", NOT_BLANK);
        validateField(house.getServiceLife(), "Service life", POSITIVE);

        return true;
    }

    private <T> void validateField(T value, String fieldName, Predicate<T> validator) {
        if (!validator.test(value)) {
            String errorMessage = String.format("Invalid %s: %s", fieldName, value);
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}