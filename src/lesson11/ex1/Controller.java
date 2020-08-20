package lesson11.ex1;

import java.util.Arrays;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    //1. RequestRooms()
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        System.out.println("Controller.requestRooms() was called");

        int apisLength = apis[0].getAll().length;
        int apis0Length = apis[0].findRooms(price, persons, city, hotel).length;
        int apis1Length = apis[1].findRooms(price, persons, city, hotel).length;
        Room[] firstArray = new Room[apisLength * 3];

        for (int i = 0; i < apis0Length; i++) {
            firstArray[i] = apis[0].findRooms(price, persons, city, hotel)[i];
        }

        for (int i = 0; i < apis[1].findRooms(price, persons, city, hotel).length; i++) {
            firstArray[i + apis0Length] =
                    apis[1].findRooms(price, persons, city, hotel)[i];
        }

        for (int i = 0; i < apis[2].findRooms(price, persons, city, hotel).length; i++) {
            firstArray[i + apis0Length + apis1Length] =
                    apis[2].findRooms(price, persons, city, hotel)[i];
        }

        int count = 0; // Счетчик не null ячеек
        for (Room el : firstArray) {
            if (el != null)
                count++;
        }

        Room[] roomsRequestRooms = new Room[count];
        int count1 = 0; // Счетчик результирующего массива без нал ячеек
        for (Room el : firstArray) {
            if (el != null) {
                roomsRequestRooms[count1] = el;
                count1++;
            }
        }

        return roomsRequestRooms;
    }

    //2. check()
    public Room[] check(API api1, API api2) {
        System.out.println("Controller.check() was called...");

        Room[] a1 = api1.getAll();
        Room[] roomsCheck = new Room[api1.getAll().length];
        int count = 0;

        for (int i = 0; i < a1.length; i++) {
            Room[] a2 = api2.findRooms(a1[i].getPrice(), a1[i].getPerson(), a1[i].getCityName(), a1[i].getHotelName());
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] != null && a2[j] != null && a1[i].getPerson() == a2[j].getPerson() &&
                        a1[i].getHotelName() == a2[j].getHotelName() &&
                        a1[i].getCityName() == a2[j].getCityName() &&
                        a1[i].getPrice() == a2[j].getPrice()) {
                    roomsCheck[count] = a1[i];
                    count++;
                }
            }
        }

        return roomsCheck;
    }

    //3. cheapestRoom()
    Room cheapestRoom() {
        System.out.println("cheapestRoom() was called...");

        int minPrise = apis[0].getAll()[0].getPrice();
        Room roomCheapestRoom = apis[0].getAll()[0];

        for (Room el : apis[0].getAll()) {
            if (el.getPrice() < minPrise) {
                roomCheapestRoom = el;
                minPrise = el.getPrice();
            }
        }

        return roomCheapestRoom;
    }
}