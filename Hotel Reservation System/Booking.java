import java.util.Date;

public class Booking {
    int userId;
    int roomNumber;
    Date checkIn;
    Date checkOut;

    public Booking (int userId, int roomNumber, Date checkIn, Date checkOut) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
