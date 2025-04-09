package org.example.house.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.house.entity.House;

import java.util.function.Predicate;
public final class HouseValidator implements Validator<House> {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);
    private static final Predicate<String> NOT_BLANK = v -> v != null && !v.isBlank();
    private static final Predicate<Number> POSITIVE = v -> v != null && v.doubleValue() > 0;

    private static final String FIELD_NUMBER_OF_ROOMS = "Number of rooms";
    private static final String FIELD_AREA = "Area";
    private static final String FIELD_FLOOR = "Floor";
    private static final String FIELD_STREET = "Street";
    private static final String FIELD_BUILDING_TYPE = "Building type";
    private static final String FIELD_SERVICE_LIFE = "Service life";

    @Override
    public boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            return false;
        }

        return validateField(house.getNumberOfRooms(), FIELD_NUMBER_OF_ROOMS, POSITIVE)
                && validateField(house.getArea(), FIELD_AREA, POSITIVE)
                && validateField(house.getFloor(), FIELD_FLOOR, POSITIVE)
                && validateField(house.getStreet(), FIELD_STREET, NOT_BLANK)
                && validateField(house.getBuildingType(), FIELD_BUILDING_TYPE, NOT_BLANK)
                && validateField(house.getServiceLife(), FIELD_SERVICE_LIFE, POSITIVE);
    }

    private <T> boolean validateField(T value, String fieldName, Predicate<T> validator) {
        if (!validator.test(value)) {
            logger.error("Invalid {}: {}", fieldName, value);
            return false;
        }
        return true;
    }
}