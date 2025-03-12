package org.example.service;

import org.example.entity.House;

import java.util.List;

/**
 * Интерфейс для работы с недвижимостью (дома).
 */
public interface HouseService {

    /**
     * Добавляет дом в сервис.
     *
     * @param house Дом, который нужно добавить.
     */
    void addHouse(House house);

    /**
     * Возвращает все дома с указанным количеством комнат.
     *
     * @param rooms Количество комнат для фильтрации.
     * @return Список домов, соответствующих критерию.
     */
    List<House> getHousesWithRooms(int rooms);

    /**
     * Возвращает все дома с указанным количеством комнат и этажами в заданном диапазоне.
     *
     * @param rooms    Количество комнат для фильтрации.
     * @param minFloor Минимальный этаж (включительно).
     * @param maxFloor Максимальный этаж (включительно).
     * @return Список домов, соответствующих критериям, или пустой список, если диапазон некорректен.
     */
    List<House> getHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor);

    /**
     * Возвращает все дома с площадью больше указанного значения.
     *
     * @param area Минимальная площадь для фильтрации.
     * @return Список домов, соответствующих критерию.
     */
    List<House> getHousesWithAreaGreaterThan(double area);
}