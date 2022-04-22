package data;

import users.Administrator;
import users.Customer;
import users.Supplier;
import users.User;
import java.util.Scanner;

public class Site {

    public User saveAdministrator() {
        return new Administrator(createLogin(), createPassword(), generationID());
    }

    public User saveCustomer() {
        return new Customer(createLogin(), createPassword(), generationID());
    }

    public User saveSupplier() {
        return new Supplier(createLogin(), createPassword(), generationID());
    }

     private String createLogin() {
        Scanner scanner = new Scanner(System.in);
        if(Repository.USER.size() >= Repository.START_AMOUNT_USER) {
            System.out.println("Enter username");
            while(true) {
                String login = scanner.nextLine();
                if (login.length() == 6) {
                    return login.toUpperCase();
                }
                System.out.println("Only 6 symbols");
            }
        }
            return generateLogin();
        }

    private String generateLogin() {
        char[] login = new char[6];
        for (int i = 0; i < login.length; i++) {
            login[i] = (char) (65 + Math.random() * 26);
        }
        return String.valueOf(login);
    }

    private int createPassword() {
        Scanner scanner = new Scanner(System.in);
        if(Repository.USER.size() >= Repository.START_AMOUNT_USER) {
            System.out.println("Enter password");
            while(true) {
                Integer password = scanner.nextInt();
                if (String.valueOf(password).length() == 6) {
                    return password;
                }
                System.out.println("Only 6 symbols");
            }
        }
        return (int) (100000 + Math.random() * 899999);
    }

    private int generationID() {
        return (int) (100000 + Math.random() * 899999);
    }
}
