package org.example.entity;

//переопределить 3 метода equals hashcode to string

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