package users;


public abstract class User{
    private final String login;
    private final String password;
    private final Integer ID;

    public User(String login, String password, int ID) {
        this.login = login;
        this.password = password;
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }
}
