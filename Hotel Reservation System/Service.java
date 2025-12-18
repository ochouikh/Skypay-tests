import java.util.ArrayList;
import java.util.Date;

public class Service {
    ArrayList<Room> rooms;
    ArrayList<Users> users;
    ArrayList<Booking> bookings;

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
    }
    
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        bookings.add(new Booking(userId, roomNumber, checkIn, checkOut));
    }

    void printAll() {
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i).roomNumber + ": " + rooms.get(i).type + " | " + rooms.get(i).pricePerNight);
        }
    }

    void setUser(int userId, int balance) {
        users.add(new Users(balance, userId));
    }

    void printAllUsers() {
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i).userId + ": " + users.get(i).balance);
        }
    }

}
