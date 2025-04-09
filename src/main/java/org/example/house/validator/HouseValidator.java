package org.example.house.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.house.entity.House;

public final class HouseValidator {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);

    public boolean validate(House house) {
        if (house == null) {
            logger.error("House is null");
            return false;
        }

        return isValid(house.getNumberOfRooms() > 0, house.getNumberOfRooms())
                && isValid(house.getArea() > 0, house.getArea())
                && isValid(house.getFloor() > 0, house.getFloor())
                && isValid(house.getStreet() != null && !house.getStreet().isBlank(), house.getStreet())
                && isValid(house.getBuildingType() != null && !house.getBuildingType().isBlank(), house.getBuildingType())
                && isValid(house.getServiceLife() > 0, house.getServiceLife());
    }

    private boolean isValid(boolean condition, Object value) {
        if (!condition) {
            logger.error("Validation failed for value: {}", value);
            return false;
        }
        return true;
    }
}