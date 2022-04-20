package users;

public class Supplier extends User{

    public Supplier(String login, int password, int ID) {
        super(login, password, ID);
    }

    @Override
    public String toString() {
        return "User: Supplier " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
