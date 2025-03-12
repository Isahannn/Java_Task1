package org.example.entity;

public class House {
    private long id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRooms;
    private String street;
    private String buildingType;
    private int serviceLife;

    public House(long id, int apartmentNumber, double area, int floor, int numberOfRooms, String street, String buildingType, int serviceLife) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.serviceLife = serviceLife;
    }

    // Геттеры
    public long getId() {
        return id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getServiceLife() {
        return serviceLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверка на ссылочное равенство
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и класс

        House house = (House) o; // Приведение типа

        // Сравнение примитивных полей
        if (apartmentNumber != house.apartmentNumber) return false;
        if (Double.compare(house.area, area) != 0) return false;
        if (floor != house.floor) return false;
        if (numberOfRooms != house.numberOfRooms) return false;
        if (serviceLife != house.serviceLife) return false;

        // Сравнение строковых полей
        if (!street.equals(house.street)) return false;
        return buildingType.equals(house.buildingType);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = apartmentNumber;
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + floor;
        result = 31 * result + numberOfRooms;
        result = 31 * result + street.hashCode();
        result = 31 * result + buildingType.hashCode();
        result = 31 * result + serviceLife;
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", street='" + street + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", serviceLife=" + serviceLife +
                '}';
    }
}