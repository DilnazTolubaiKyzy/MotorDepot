package com.peaksoft;

public class Truck {
    private long id;
    private String name;
    private Driver driver;
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Truck creatTruck(long id, String name, Driver driver, Status status) {
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }

    @Override
    public String toString() {
        return " "+id+
                "| " + name +
                "   | " + driver +
                "            | " + status ;

    }

    public Object getState() {
        return "";
    };
}
