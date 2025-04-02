package service;

import org.example.house.entity.House;
import org.example.house.service.HouseService;
import org.example.house.service.HouseServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class HouseServiceTest {
    private HouseService houseService;

    @BeforeMethod
    public void setUp() {
        houseService = new HouseServiceImpl();
    }

    // Тесты для Optional методов
    @Test
    public void testFindHouseById_Found() {
        House expected = new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10);
        houseService.addHouse(expected);

        Optional<House> result = houseService.findHouseById(1);

        assertTrue(result.isPresent());
        assertEquals(result.get(), expected);
    }

    @Test
    public void testFindHouseById_NotFound() {
        Optional<House> result = houseService.findHouseById(999);
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindHousesWithRoomsOptional_Positive() {
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10));
        houseService.addHouse(new House(2, 102, 80.0, 6, 3, "Main St", "Apt", 10));

        Optional<List<House>> result = houseService.findHousesWithRoomsOptional(3);

        assertTrue(result.isPresent());
        assertEquals(result.get().size(), 2);
    }

    @Test
    public void testFindHousesWithRoomsOptional_Empty() {
        Optional<List<House>> result = houseService.findHousesWithRoomsOptional(3);
        assertFalse(result.isPresent());
    }

    // Оригинальные тесты (адаптированные)
    @Test
    public void testAddHouse_Null() {
        houseService.addHouse(null);
        assertEquals(houseService.findAllHouses().size(), 0);
    }

    @Test
    public void testFindHousesWithRooms() {
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10));
        List<House> result = houseService.findHousesWithRooms(3);
        assertEquals(result.size(), 1);
    }

    @Test
    public void testFindHousesWithAreaGreaterThan() {
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10));
        List<House> result = houseService.findHousesWithAreaGreaterThan(70);
        assertEquals(result.size(), 1);
    }

    @Test
    public void testFindHousesWithRoomsAndFloorRange() {
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10));
        List<House> result = houseService.findHousesWithRoomsAndFloorRange(3, 4, 6);
        assertEquals(result.size(), 1);
    }

    // Комплексный тест
    @Test
    public void testComplexScenario() {
        // Добавляем дома
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main St", "Apt", 10));
        houseService.addHouse(new House(2, 201, 85.0, 3, 2, "Second St", "Apt", 15));

        // Ищем по ID
        Optional<House> house1 = houseService.findHouseById(1);
        assertTrue(house1.isPresent());

        // Ищем несуществующий
        Optional<House> house3 = houseService.findHouseById(3);
        assertFalse(house3.isPresent());

        // Ищем с Optional
        Optional<List<House>> twoRoomHouses = houseService.findHousesWithRoomsOptional(2);
        assertTrue(twoRoomHouses.isPresent());
        assertEquals(twoRoomHouses.get().size(), 1);

        // Удаляем дом
        house1.ifPresent(houseService::removeHouse);
        assertEquals(houseService.findAllHouses().size(), 1);
    }
}