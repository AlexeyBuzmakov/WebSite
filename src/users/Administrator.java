package users;

public class Administrator extends User{

    public Administrator(String login, String password, int ID) {
        super(login, password, ID);
    }

    @Override
    public String toString() {
        return "User: Administrator " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
