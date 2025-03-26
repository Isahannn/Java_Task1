package service;

import org.example.House.entity.House;
import org.example.House.service.HouseService;
import org.example.House.service.HouseServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class HouseServiceTest {
    private HouseService houseService;

    @BeforeMethod
    public void setUp() {
        houseService = new HouseServiceImpl();
    }

    @Test
    public void testFindHousesWithRooms_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 3, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.findHousesWithRooms(3);

        // then
        assertEquals(result.size(), 2);
    }

    @Test
    public void testFindHousesWithRooms_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithRooms(4);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHousesWithRoomsAndFloorRange_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithRoomsAndFloorRange(3, 4, 6);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }

    @Test
    public void testFindHousesWithRoomsAndFloorRange_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithRoomsAndFloorRange(3, 6, 8);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHousesWithAreaGreaterThan_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithAreaGreaterThan(70);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }

    @Test
    public void testFindHousesWithAreaGreaterThan_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithAreaGreaterThan(80);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAddHouse_NullHouse() {
        // when
        houseService.addHouse(null);

        // then
        assertEquals(houseService.findAllHouses().size(), 0);
    }

    @Test
    public void testFindHousesWithRooms_EmptyList() {
        // when
        List<House> result = houseService.findHousesWithRooms(3);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHousesWithRoomsAndFloorRange_InvalidRange() {
        // given
        houseService.addHouse(new House(1, 101, 725.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithRoomsAndFloorRange(3, 8, 4);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHousesWithAreaGreaterThan_NegativeArea() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.findHousesWithAreaGreaterThan(-10);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }
}