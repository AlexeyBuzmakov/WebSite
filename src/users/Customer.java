package users;

public class Customer extends User{

    public Customer(String login, int password, int ID) {
        super(login, password, ID);
    }

    @Override
    public String toString() {
        return "User: Customer " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
