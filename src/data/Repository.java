package data;

import users.Customer;
import users.Supplier;
import users.User;
import utils.Verification;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository{
    private static final ArrayList<User>USER = new ArrayList<>();
    public static final int START_AMOUNT_USER = 100;
    public static final int START_AMOUNT_ADMINISTRATOR = 3;
    public static final int START_AMOUNT_SUPPLIER = 15;
    public static final int START_AMOUNT_CUSTOMER = START_AMOUNT_USER - (START_AMOUNT_ADMINISTRATOR + START_AMOUNT_SUPPLIER);

    public ArrayList<User> getUSER() {
        return USER;
    }

    public void showRepository() {
        for (User user : USER) {
            System.out.println(user);
        }
    }

    public void searchUserByID() {
        System.out.println("Введите ID для поиска");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int ID = scanner.nextInt();
            for (User user : USER) {
                if (user.getID() == ID) {
                    System.out.println(user);
                    return;
                }
            }
            System.out.println("ID not found. Try again.");
        }
    }

    public void showCustomers() {
        for (User user : USER) {
            if (user instanceof Customer) {
                System.out.println(user);
            }
        }
        System.out.println(Customer.getAmountCustomer() + " customers");
    }

    public void showSuppliers() {
        for (User user : USER) {
            if (user instanceof Supplier) {
                System.out.println(user);
            }
        }
        System.out.println(Supplier.getAmountSupplier() + " suppliers");
    }

    public void showCurrentUser() {
        System.out.println(USER.get(Verification.getCurrentUser()));
    }

    public void showListProductCustomers() {
        System.out.println(((Customer) USER.get(Verification.getCurrentUser())).getListProduct());
    }

    public void showListProductSuppliers() {
        System.out.println(((Supplier) USER.get(Verification.getCurrentUser())).getListProduct());
    }
}
