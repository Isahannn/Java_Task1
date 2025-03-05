package org.example.Validator;


import org.example.entity.House;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);

    public static boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            return false;
        }

        if (house.getId() <= 0) {
            logger.error("Invalid house ID: {}", house.getId());
            return false;
        }

        if (house.getNumberOfRooms() <= 0) {
            logger.error("Invalid number of rooms: {}", house.getNumberOfRooms());
            return false;
        }

        if (house.getArea() <= 0) {
            logger.error("Invalid area: {}", house.getArea());
            return false;
        }

        if (house.getFloor() <= 0) {
            logger.error("Invalid floor: {}", house.getFloor());
            return false;
        }

        if (house.getStreet() == null || house.getStreet().isEmpty()) {
            logger.error("Street is null or empty");
            return false;
        }

        if (house.getBuildingType() == null || house.getBuildingType().isEmpty()) {
            logger.error("Building type is null or empty");
            return false;
        }

        if (house.getServiceLife() <= 0) {
            logger.error("Invalid service life: {}", house.getServiceLife());
            return false;
        }

        return true;
    }
}