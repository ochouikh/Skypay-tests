import java.util.Date;

public class Booking {
    private int userId;
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;
    private String roomType;
    private int roomPricePerNight;
    private int userBalanceAtBooking;

    public Booking (int userId, int roomNumber, Date checkIn, Date checkOut, String roomType, int roomPricePerNight, int userBalanceAtBooking) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
        this.roomPricePerNight = roomPricePerNight;
        this.userBalanceAtBooking = userBalanceAtBooking;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public int getUserBalanceAtBooking() {
        return userBalanceAtBooking;
    }
}
