package org.example.house.entity;

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

    // getter
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        return apartmentNumber == house.apartmentNumber &&
                Double.compare(house.area, area) == 0 &&
                floor == house.floor &&
                numberOfRooms == house.numberOfRooms &&
                serviceLife == house.serviceLife &&
                street.equals(house.street) &&
                buildingType.equals(house.buildingType);
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
        final StringBuilder sb = new StringBuilder("House{");
        sb.append("id=").append(id);
        sb.append(", apartmentNumber=").append(apartmentNumber);
        sb.append(", area=").append(area);
        sb.append(", floor=").append(floor);
        sb.append(", numberOfRooms=").append(numberOfRooms);
        sb.append(", street='").append(street).append('\'');
        sb.append(", buildingType='").append(buildingType).append('\'');
        sb.append(", serviceLife=").append(serviceLife);
        sb.append('}');
        return sb.toString();
    }
}
