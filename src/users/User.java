package users;

public abstract class User{
    private final String login;
    private final Integer password;
    private final Integer ID;

    public User(String login, int password, int ID) {
        this.login = login;
        this.password = password;
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public Integer getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }
}
