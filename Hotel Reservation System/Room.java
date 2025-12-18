public class Room {
    int roomNumber;
    RoomType type;
    int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.roomNumber = roomNumber;
    }
}
