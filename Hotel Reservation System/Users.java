public class Users {
    private int balance;
    private int userId;

    public Users(int balance, int userId) {
        this.balance = balance;
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }
    public int getUserId() {
        return userId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
