import java.util.ArrayList;
import java.util.Date;

public class Service {
    private ArrayList<Room> rooms;
    private ArrayList<Users> users;
    private ArrayList<Booking> bookings;

    public Service() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        if (roomPricePerNight <= 0) {
            throw new IllegalArgumentException("Price per night must be positive");
        }
        if (rooms.stream().anyMatch(room -> room.getRoomNumber() == roomNumber)) {
            throw new IllegalArgumentException("Room number already exists");
        }
        Booking booking = bookings.stream().filter(item -> item.getRoomNumber() == roomNumber).findFirst().orElse(null);
        if (booking != null) {
            throw new IllegalArgumentException("Room is already booked");
        }
        rooms.add(new Room(roomNumber, roomType.getType(), roomPricePerNight));
    }
    
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (checkOut.before(checkIn) || checkIn.equals(checkOut)) {
            throw new IllegalArgumentException("Invalid check-in and check-out dates");
        }
        Booking booking = bookings.stream().filter(item -> item.getRoomNumber() == roomNumber).findFirst().orElse(null);
        if (booking != null && !(checkOut.before(booking.getCheckIn()) || checkIn.after(booking.getCheckOut()))) {
            throw new IllegalArgumentException("Room is already booked for the selected dates");
        }
        Users user = users.stream().filter(item -> item.getUserId() == userId).findFirst().orElseThrow(() -> new IllegalArgumentException("User not found"));
        Room room = rooms.stream().filter(item -> item.getRoomNumber() == roomNumber).findFirst().orElseThrow(() -> new IllegalArgumentException("Room not found"));
        if (user.getBalance() < room.getPricePerNight()) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        int userBalanceAtBooking = user.getBalance();
        user.setBalance(user.getBalance() - room.getPricePerNight());
        bookings.add(new Booking(userId, roomNumber, checkIn, checkOut, room.getType(), room.getPricePerNight(), userBalanceAtBooking));
    }

    void printAll() {
        System.out.println("=== ROOMS (latest to oldest) ===");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            Room room = rooms.get(i);
            System.out.println("Room " + room.getRoomNumber() + ": " + room.getType() + " | Price: " + room.getPricePerNight());
        }
        System.out.println("\n=== BOOKINGS (latest to oldest) ===");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            Booking booking = bookings.get(i);
            System.out.println("Booking - User ID: " + booking.getUserId() + 
                " | Room " + booking.getRoomNumber() + ": " + booking.getRoomType() + 
                " | Price: " + booking.getRoomPricePerNight() +
                " | User Balance at Booking: " + booking.getUserBalanceAtBooking() +
                " | Check-in: " + booking.getCheckIn() + 
                " | Check-out: " + booking.getCheckOut());
        }
    }

    void setUser(int userId, int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (users.stream().anyMatch(user -> user.getUserId() == userId)) {
            throw new IllegalArgumentException("User ID already exists");
        }
        users.add(new Users(balance, userId));
    }

    void printAllUsers() {
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i).getUserId() + ": " + users.get(i).getBalance());
        }
    }

}
