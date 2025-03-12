package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.House;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация интерфейса HouseService для работы с домами.
 */
public class HouseServiceImpl implements HouseService {
    private static final Logger logger = LogManager.getLogger(HouseServiceImpl.class);

    // Внутренний список домов
    private final List<House> houses = new ArrayList<>();

    /**
     * Добавляет дом в список.
     *
     * @param house Дом, который нужно добавить.
     */
    @Override
    public void addHouse(House house) {
        logger.info("Добавление дома: {}", house);
        if (house != null) {
            houses.add(house);
        } else {
            logger.warn("Попытка добавить null-объект!");
        }
    }

    /**
     * Возвращает дома с указанным количеством комнат.
     *
     * @param rooms Количество комнат.
     * @return Список домов.
     */
    @Override
    public List<House> getHousesWithRooms(int rooms) {
        logger.info("Поиск домов с {} комнатами", rooms);
        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает дома с указанным количеством комнат и этажами в заданном диапазоне.
     *
     * @param rooms    Количество комнат.
     * @param minFloor Минимальный этаж (включительно).
     * @param maxFloor Максимальный этаж (включительно).
     * @return Список домов.
     */
    @Override
    public List<House> getHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor) {
        logger.info("Поиск домов с {} комнатами и этажами от {} до {}", rooms, minFloor, maxFloor);

        if (minFloor > maxFloor) {
            logger.warn("Некорректный диапазон этажей: minFloor ({}) > maxFloor ({})", minFloor, maxFloor);
            return new ArrayList<>();
        }

        return houses.stream()
                .filter(house -> house.getNumberOfRooms() == rooms &&
                        house.getFloor() >= minFloor &&
                        house.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает дома с площадью больше заданной.
     *
     * @param area Минимальная площадь.
     * @return Список домов.
     */
    @Override
    public List<House> getHousesWithAreaGreaterThan(double area) {
        logger.info("Поиск домов с площадью больше {}", area);
        return houses.stream()
                .filter(house -> house.getArea() > area)
                .collect(Collectors.toList());
    }
}