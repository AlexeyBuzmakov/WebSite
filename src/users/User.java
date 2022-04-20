package users;

public abstract class User implements Comparable<User>{
    private final String login;
    private final int password;
    private final int ID;

    public User(String login, int password, int ID) {
        this.login = login;
        this.password = password;
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int compareTo(User o) {
        return this.ID.;
    }
}
