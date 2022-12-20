package com.peaksoft;

public class Driver {
    private long id;
    private String name;

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

    public static Driver creatDriver(String name, long id){
        Driver driver = new Driver();
        driver.name = name;
        driver.id = id;
        return driver;
    }
    public  String driver(){
        return " | "+id+
                " | "+name+ "    | ";
    }

    @Override
    public String toString() {
        return "";
    }
}
