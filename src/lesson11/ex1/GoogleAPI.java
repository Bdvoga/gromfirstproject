package lesson11.ex1;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] roomsGoogleAPI = new Room[rooms.length];

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price &&
                    rooms[i].getPerson() == persons &&
                    rooms[i].getCityName() == city &&
                    rooms[i].getHotelName() == hotel)

                roomsGoogleAPI[i] = rooms[i];
        }

        System.out.println("GoogleAPI  was called...");
        return roomsGoogleAPI;
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
