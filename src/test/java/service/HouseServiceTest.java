package service;

import org.example.entity.House;
import org.example.creator.HouseFactory;
import org.example.service.HouseService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.*;


public class HouseServiceTest {

    private HouseService houseService;

    @BeforeMethod
    public void setUp() {
        houseService = new HouseService();
    }

    @Test
    public void testGetHousesWithRooms_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithRooms(3);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }

    @Test
    public void testGetHousesWithRooms_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithRooms(4);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetHousesWithRoomsAndFloorRange_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithRoomsAndFloorRange(3, 4, 8);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }

    @Test
    public void testGetHousesWithRoomsAndFloorRange_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithRoomsAndFloorRange(3, 6, 8);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetHousesWithAreaGreaterThan_PositiveCase() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithAreaGreaterThan(70);

        // then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), 1);
    }

    @Test
    public void testGetHousesWithAreaGreaterThan_NoMatch() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));
        houseService.addHouse(new House(2, 202, 60.0, 3, 2, "Second Street", "Apartment", 15));

        // when
        List<House> result = houseService.getHousesWithAreaGreaterThan(80);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAddHouse_NullHouse() {
        // given
        House house = null;

        // when
        houseService.addHouse(house);

        // then
        assertEquals(houseService.getHousesWithRooms(3).size(), 0);
    }

    @Test
    public void testGetHousesWithRooms_EmptyList() {
        // given
        // No houses added

        // when
        List<House> result = houseService.getHousesWithRooms(3);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetHousesWithRoomsAndFloorRange_InvalidRange() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.getHousesWithRoomsAndFloorRange(3, 8, 4); // Invalid range

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetHousesWithAreaGreaterThan_NegativeArea() {
        // given
        houseService.addHouse(new House(1, 101, 75.5, 5, 3, "Main Street", "Apartment", 10));

        // when
        List<House> result = houseService.getHousesWithAreaGreaterThan(-10); // Negative area

        // then
        assertEquals(result.size(), 1); // All houses have area > -10
    }
}