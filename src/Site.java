import users.Administrator;
import users.Customer;
import users.Supplier;
import users.User;

public class Site {

    public User saveAdministrator() {
        return new Administrator(generationLogin(), generationPassword(),generationID());
    }

    public User saveCustomer() {
        return new Customer(generationLogin(), generationPassword(), generationID());
    }

    public User saveSupplier() {
        return new Supplier(generationLogin(), generationPassword(), generationID());
    }

    private String generationLogin() {
        char[]login = new char[6];
        for(int i = 0; i < login.length; i++) {
            login[i] = (char) (65 + Math.random() * 26);
        }
        return String.valueOf(login);
    }

    private int generationPassword() {
        return (int) (100000 + Math.random() * 899999);
    }

    private int generationID() {
        return
    }
}
