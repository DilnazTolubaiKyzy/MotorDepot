package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    private static GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    private static Path URI_Truck = Paths.get("truck.json");
    private static Path URI_Driver = Paths.get("Driver.json");
    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.creatTruck(1, "Renault", new Driver(), Status.BASE),
                Truck.creatTruck(2, "Volvo", new Driver(), Status.BASE),
                Truck.creatTruck(3, "DAF XT", new Driver(), Status.BASE),
        };
        Driver[] drivers = {
                Driver.creatDriver("Uson", 1),
                Driver.creatDriver("Petr", 2),
                Driver.creatDriver("Askar", 3),
        };
        String json2 = GSON.toJson(drivers);
        writeDriver(json2);
        String json1 = GSON.toJson(trucks);
        writeTruck(json1);
        Truck[] trucks1 = GSON.fromJson(readTruck(), Truck[].class);
        System.out.println(String.format(
                "%2s | %15s | %15s | %15s |",
                "#","Truck","Driver","State"));
        System.out.println("---+-----------------+-----------------+------------------");
        for (Truck truck : trucks1) {
            System.out.println(truck.getDriver()==null ? String.format(
                    "%2d | %15s | %15s | %15s |",
                    truck.getId(),truck.getName(),"",truck.getStatus()):String.format(
                    "%2d | %15s | %15s | %15s |",
                    truck.getId(),truck.getName(),truck.getDriver(),truck.getStatus()));
        }

        System.out.println();
        System.out.println("# | Driver         Truck");
        System.out.println("__+____________+___________");
        Driver[] drivers1 = GSON.fromJson(readDriver(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.driver());
        }
        while (true) {
            TruckService truckService = new TruckService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите грузавика или нажмите на ноль");
            long id = scanner.nextLong();
            truckService.truck(trucks, id, drivers);
            if (id == 0) {
                break;
            }
            for (int i = 0; i < trucks.length; i++) {
                if (trucks[i].getId() == id) {
                    System.out.println("id   " + trucks[i].getId());
                    System.out.println("Driver  " + trucks[i].getDriver().getName());
                    System.out.println("Status  " + trucks[i].getStatus());
                    System.out.println("Truck  " + trucks[i].getName());
                }
            }
        }


    }
    public static void writeTruck(String json) {
        Path write = Paths.get(String.valueOf(URI_Truck));
        try {
            Files.writeString(URI_Truck, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void writeDriver(String json) {
        Path write = Paths.get(String.valueOf(URI_Driver));
        try {
            Files.writeString(URI_Driver, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    public static String readTruck() {
        String json = "";
        int a;
        try {
            FileReader reader = new FileReader(String.valueOf(URI_Truck));
            while ((a = reader.read()) != -1) {
                json += (char) a;

            }
        } catch (IOException r) {
            r.printStackTrace();
        }
        return json;
    }

    public static String readDriver() {
        String json = "";
        int a;
        try {
            FileReader fileReader = new FileReader(String.valueOf(URI_Driver));
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        return json;
    }
}