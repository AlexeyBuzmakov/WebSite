package users;

public class Administrator extends User{
    private static int amountAdministrator;

    public Administrator(String login, int password, int ID) {
        super(login, password, ID);
        amountAdministrator++;
    }

    public static int getAmountAdministrator() {
        return amountAdministrator;
    }

    @Override
    public String toString() {
        return "User: Administrator " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
