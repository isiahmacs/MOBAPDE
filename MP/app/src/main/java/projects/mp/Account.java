package projects.mp;

/**
 * Created by isiah on 13/11/2017.
 */

public class Account {

    public static final String TABLE_NAME = "accounts";
    public static final String COLUMN_ID = "accountID";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    private int accountId;
    private String username, password;

    public Account() {}

    public Account(int accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public Account(String username, String passwrod) {
        this.username = username;
        this.password = password;
    }

    public int getAccountID() {
        return accountId;
    }

    public void setAccountID(int id) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
