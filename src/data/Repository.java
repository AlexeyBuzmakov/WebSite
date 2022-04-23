package data;

import users.Administrator;
import users.Customer;
import users.Supplier;
import users.User;
import utils.Verification;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository{
    public static final ArrayList<User>USER = new ArrayList<>();
    public static final int START_AMOUNT_USER = 100;
    public static final int START_AMOUNT_ADMINISTRATOR = 3;
    public static final int START_AMOUNT_SUPPLIER = 15;
    public static final int START_AMOUNT_CUSTOMER = START_AMOUNT_USER - (START_AMOUNT_ADMINISTRATOR + START_AMOUNT_SUPPLIER);

    public void createRepository() {
        Site site = new Site();
        for(int i = 0; i < START_AMOUNT_ADMINISTRATOR; i++) {
            USER.add(site.saveAdministrator());
        }
        for(int i = 0; i < START_AMOUNT_SUPPLIER; i++) {
            USER.add(site.saveSupplier());
        }
        for(int i = 0; i < START_AMOUNT_CUSTOMER; i++) {
            USER.add(site.saveCustomer());
        }
    }

    public void showRepository() {
        for(User user : USER) {
            System.out.println(user);
        }
    }

    public void searchUserByID() {
        if (USER.get(Verification.getCurrentUser()) instanceof Administrator) {
            System.out.println("Введите ID для поиска");
            Scanner scanner = new Scanner(System.in);
            while(true) {
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
    System.out.println("Insufficient access rights. Only for administrators.");
}

    public void showCustomers() {
        if (USER.get(Verification.getCurrentUser()) instanceof Administrator) {
            for (User user : USER) {
                if (user instanceof Customer) {
                    System.out.println(user);
                }
            }
            System.out.println(Customer.getAmountCustomer() + " customers");
            return;
        }
        System.out.println("Insufficient access rights. Only for administrators.");
    }

    public void showSuppliers() {
        if (USER.get(Verification.getCurrentUser()) instanceof Administrator) {
            for (User user : USER) {
                if (user instanceof Supplier) {
                    System.out.println(user);
                }
            }
            System.out.println(Supplier.getAmountSupplier() + " suppliers");
            return;
        }
        System.out.println("Insufficient access rights. Only for administrators.");
    }

    public void showCurrentUser() {
        System.out.println(USER.get(Verification.getCurrentUser()));
    }

    public void addNewUser() {
        Site site = new Site();
        USER.add(site.saveCustomer());
        System.out.println("Congratulations! New user registered.");
    }

    public void showListProductCustomers() {
        if(USER.get(Verification.getCurrentUser()) instanceof Customer) {
        System.out.println(((Customer)USER.get(Verification.getCurrentUser())).getListProduct());
        return;
        }
        System.out.println("Insufficient access rights. Only for customers.");
    }

    public void showListProductSuppliers() {
        if(USER.get(Verification.getCurrentUser()) instanceof Supplier) {
        System.out.println(((Supplier)USER.get(Verification.getCurrentUser())).getListProduct());
        return;
        }
        System.out.println("Insufficient access rights. Only for suppliers.");
    }
}
