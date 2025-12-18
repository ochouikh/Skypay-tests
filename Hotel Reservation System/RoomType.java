public class RoomType {
    String type; // standard suite, junior suite and master suite.

    public RoomType(String type) {
        if (!type.equals("standard suite") && !type.equals("junior suite") && !type.equals("master suite")) {
            throw new IllegalArgumentException("Invalid room type");
        }
        this.type = type;
    }
}
