package com.peaksoft;

import java.util.Scanner;

public class TruckService {
    Scanner sc = new Scanner(System.in);
    static String dri;

    public  void truck(Truck[] trucks,long id,Driver[] drivers){
        for (int j = 0; j < drivers.length; j++) {
            for (int i = 0; i < trucks.length; i++) {
                if (trucks[i].getId() == id){
                    if (trucks[i].getDriver().getName() == null){
                        dri = " ";

                    }else {
                        dri = trucks[i].getDriver().getName();
                    }
                    System.out.println("id   "+trucks[i].getId());
                    System.out.println("Driver  "+dri);
                    System.out.println("Status  "+trucks[i].getStatus());
                    System.out.println("Truck  "+trucks[i].getName());
                    if (trucks[i].getStatus().equals(Status.BASE)){
                        System.out.println("Если хотоите отправить в путь - 1");
                        System.out.println("Если хотите выбрать водитель - 2");
                        System.out.println("Если хотите отправить на ремонт - 3");
                        int a = sc.nextInt();
                        if (a == 1) {
                            startDriving(drivers[i],trucks[i]);
                            trucks[i].setStatus(Status.ROUTE);
                            System.out.println("Успешна вышли на маршрут");
                        } else if (a == 2) {
                            changeDriver(drivers,trucks[i]);
                            System.out.println("Если хотите отправить в путь нажмите на 1 если нет на 0");

                        } else if (a == 0) {
                            System.out.println("Грузавик остался на базе");
                            System.out.println(trucks[i]);
                        } else  {
                            startRepair(trucks[i]);
                            trucks[i].setStatus(Status.REPAIR);
                        }
                    }
                    if (trucks[i].getStatus().equals(Status.ROUTE)){
                        int b = sc.nextInt();
                        if (b == 1){
                            System.out.println("Грузавик уже в пути");
                        } else if (b == 2) {
                            System.out.println("Грузовик в пути, невозможно сменить водителя");
                        } else {
                            trucks[i].setStatus(Status.REPAIR);
                            startRepair(trucks[i]);
                            System.out.println("Выберите грузавика");
                        }

                    }
                    if (trucks[i].getStatus().equals(Status.REPAIR)){
                        int c = sc.nextInt();

                        if (c == 1){
                            startDriving(drivers[i],trucks[i]);
                        } else if (c == 2) {
                            System.out.println("Нельзя сменить водитель");
                        } else {
                            System.out.println("Уже в ремонте");
                        }  System.out.println("Выберите грузавика");
                    }
                }

            }
        }
    }

    public  void changeDriver(Driver [] drivers,Truck truck){
        System.out.println("напишите id водителя");
        Scanner sc = new Scanner(System .in);
        long id = sc.nextInt();
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].getId() == id){
                System.out.println("Теперь грузавик "+truck.getName()+"  водитель "+drivers[i].getName());
            }
        }
    }
    public void startDriving(Driver driver, Truck truck){
        System.out.println("Грузавик "+truck.getName()+" ведет "+driver.getName());
    }
    public void startRepair(Truck truck){
        System.out.println("Теперь грузавик "+truck.getName()+" на ремонте");
    }
}
