//обьеденить ретурны
//в иквелс если поле(стринг)проыерка на налл


package org.example.House.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class HouseValidator {

    private static final Logger logger = LogManager.getLogger(HouseValidator.class);

    // Общий метод для валидации
    private static <T> boolean validate(T value, Predicate<T> condition, String errorMessage) {
        if (condition.test(value)) {
            logger.error(errorMessage, value);
            return false;
        }
        return true;
    }

    // Проверка ID
    public static boolean isValidId(long id) {
        return validate(id, value -> value <= 0, "Invalid house ID: {}");
    }

    // Проверка количества комнат
    public static boolean isValidNumberOfRooms(int numberOfRooms) {
        return validate(numberOfRooms, value -> value <= 0, "Invalid number of rooms: {}");
    }

    // Проверка площади
    public static boolean isValidArea(double area) {
        return validate(area, value -> value <= 0, "Invalid area: {}");
    }

    // Проверка этажа
    public static boolean isValidFloor(int floor) {
        return validate(floor, value -> value <= 0, "Invalid floor: {}");
    }

    // Проверка улицы
    public static boolean isValidStreet(String street) {
        return validate(street, value -> value == null || value.isEmpty(), "Street is null or empty");
    }

    // Проверка типа здания
    public static boolean isValidBuildingType(String buildingType) {
        return validate(buildingType, value -> value == null || value.isEmpty(), "Building type is null or empty");
    }

    // Проверка срока службы
    public static boolean isValidServiceLife(int serviceLife) {
        return validate(serviceLife, value -> value <= 0, "Invalid service life: {}");
    }

    // Общая проверка всех параметров
    public static boolean validateHouseParameters(long id, int numberOfRooms, double area, int floor,
                                                  String street, String buildingType, int serviceLife) {
        boolean isValid = true;

        isValid &= isValidId(id);
        isValid &= isValidNumberOfRooms(numberOfRooms);
        isValid &= isValidArea(area);
        isValid &= isValidFloor(floor);
        isValid &= isValidStreet(street);
        isValid &= isValidBuildingType(buildingType);
        isValid &= isValidServiceLife(serviceLife);

        return isValid;
    }
}