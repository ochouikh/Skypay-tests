public class RoomType {
    private String type;

    public RoomType(String type) {
        if (!type.equals("standard suite") && !type.equals("junior suite") && !type.equals("master suite")) {
            throw new IllegalArgumentException("Invalid room type");
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
