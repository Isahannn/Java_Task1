package org.example.Validator;

import org.example.entity.House;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class HouseValidator implements Validator<House> {
    private static final Logger logger = LogManager.getLogger(HouseValidator.class);

    // Список проверок
    private static final List<HouseCheck> VALIDATION_CHECKS = Arrays.asList(
            new HouseCheck(h -> h.getId() <= 0, "Invalid house ID: {}", h -> new Object[]{h.getId()}),
            new HouseCheck(h -> h.getNumberOfRooms() <= 0, "Invalid number of rooms: {}", h -> new Object[]{h.getNumberOfRooms()}),
            new HouseCheck(h -> h.getArea() <= 0, "Invalid area: {}", h -> new Object[]{h.getArea()}),
            new HouseCheck(h -> h.getFloor() <= 0, "Invalid floor: {}", h -> new Object[]{h.getFloor()}),
            new HouseCheck(h -> h.getStreet() == null || h.getStreet().isEmpty(), "Street is null or empty", h -> new Object[]{}),
            new HouseCheck(h -> h.getBuildingType() == null || h.getBuildingType().isEmpty(), "Building type is null or empty", h -> new Object[]{}),
            new HouseCheck(h -> h.getServiceLife() <= 0, "Invalid service life: {}", h -> new Object[]{h.getServiceLife()})
    );

    @Override
    public boolean validate(House house) {
        if (house == null) {
            logger.error("House object is null");
            return false;
        }

        // Проверяем все условия
        return VALIDATION_CHECKS.stream()
                .noneMatch(check -> {
                    if (check.condition().test(house)) {
                        logger.error(check.errorMessage(), check.argsSupplier().apply(house));
                        return true;
                    }
                    return false;
                });
    }

    // Внутренний класс для хранения проверок
    private static class HouseCheck {
        private final Predicate<House> condition;
        private final String errorMessage;
        private final Function<House, Object[]> argsSupplier;

        public HouseCheck(Predicate<House> condition, String errorMessage, Function<House, Object[]> argsSupplier) {
            this.condition = condition;
            this.errorMessage = errorMessage;
            this.argsSupplier = argsSupplier;
        }

        public Predicate<House> condition() {
            return condition;
        }

        public String errorMessage() {
            return errorMessage;
        }

        public Function<House, Object[]> argsSupplier() {
            return argsSupplier;
        }
    }
}