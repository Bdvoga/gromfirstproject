package lesson11.ex1;

import static lesson11.ex1.Controller.deleteNull;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] roomsTripAdvisorAPI = new Room[rooms.length];
        int countWithoutNull = 0;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price &&
                    (rooms[i].getPerson() <= persons + 1 && rooms[i].getPerson() >= persons - 1) &&
                    rooms[i].getCityName() == city &&
                    rooms[i].getHotelName() == hotel) {
                roomsTripAdvisorAPI[i] = rooms[i];
                countWithoutNull++;
            }
        }
        System.out.println("TripAdvisorAPI  was called...");

        return deleteNull(roomsTripAdvisorAPI, countWithoutNull);
    }

    @Override
    public Room[] getAll() {
        Room[] roomsGetAll = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            roomsGetAll[i] = rooms[i];
        }

        return roomsGetAll;
    }
}
