package lesson11.ex1;

import java.util.Arrays;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        Room room1 = new Room(1,1, 1, new Date(), "C1", "H1");
        Room room2 = new Room(2,15, 1, new Date(), "C1", "H1");
        Room room3 = new Room(3,15, 10, new Date(), "C1", "H1");
        Room room4 = new Room(4,200, 4, new Date(), "C1", "H1");
        Room room5 = new Room(5,4, 10, new Date(), "C1", "H1");

        Room[] rooms = {room1, room2, room3, room4, room5};
//--------------------------------------------
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);

        for (Room el : bookingComAPI.findRooms(10, 10, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();

//-------------------------------------------
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);

        for (Room el : tripAdvisorAPI.findRooms(200, 3, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();
//---------------------------------------------
        GoogleAPI googleAPI = new GoogleAPI(rooms);

        for (Room el : googleAPI.findRooms(15, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();
//-----------------------------
        //Controller
        API[] apis = {bookingComAPI, tripAdvisorAPI, googleAPI};

        Controller controller = new Controller(apis);

        //1. requestRooms
        for (Room el : controller.requestRooms(5, 1, "C1", "H1")) {
            if (el != null)
                System.out.println(el.getId());
            else System.out.println("null");
        }

        //2. check
        for (Room el : controller.check(tripAdvisorAPI, googleAPI)) {
            if (el != null)
                System.out.println(el.getId());
        }

        //3. cheapestRoom()
        System.out.println(controller.cheapestRoom().getPrice());

    }
}
