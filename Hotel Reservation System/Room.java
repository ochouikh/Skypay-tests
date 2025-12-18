public class Room {
    private  int roomNumber;
    private  String type;
    private  int pricePerNight;

    public Room(int roomNumber, String type, int pricePerNight) {
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.roomNumber = roomNumber;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }
}
