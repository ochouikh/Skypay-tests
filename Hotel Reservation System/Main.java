import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            Service service = new Service();
            service.setRoom(1, new RoomType("standard suite"), 1000);
            service.setRoom(2, new RoomType("junior suite"), 2000);
            service.setRoom(3, new RoomType("master suite"), 3000);
            service.setUser(1, 5000);
            service.setUser(2, 10000);

            service.bookRoom(1, 2, dateFormat.parse("2026-06-30"), dateFormat.parse("2026-07-07"));
            // service.bookRoom(1, 2, dateFormat.parse("2026-07-07"), dateFormat.parse("2025-06-30"));
            // service.bookRoom(1, 1, dateFormat.parse("2026-07-07"), dateFormat.parse("2026-07-08"));

            service.bookRoom(2, 1, dateFormat.parse("2026-07-07"), dateFormat.parse("2026-07-09"));
            service.bookRoom(2, 3, dateFormat.parse("2026-07-07"), dateFormat.parse("2026-07-08"));

            // service.setRoom(1, new RoomType("master suite"), 10000);

            service.printAll();
            service.printAllUsers();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}