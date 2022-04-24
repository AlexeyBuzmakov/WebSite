package data;

import users.Administrator;
import users.Customer;
import users.Supplier;
import utils.Verification;

import java.util.Scanner;

public class Site {
    Repository repository = new Repository();

    public void createRepository() {
        for (int i = 0; i < Repository.START_AMOUNT_ADMINISTRATOR; i++) {
            registrationAdministrator();
        }
        for (int i = 0; i < Repository.START_AMOUNT_SUPPLIER; i++) {
            registrationSupplier();
        }
        for (int i = 0; i < Repository.START_AMOUNT_CUSTOMER; i++) {
            registrationCustomer();
        }
    }

    public void showRepository () {
        repository.showRepository();
    }

    private void registrationAdministrator() {
        repository.getUSER().add(new Administrator(createLogin(), createPassword(), generationID()));
    }

    private void registrationSupplier() {
        repository.getUSER().add(new Supplier(createLogin(), createPassword(), generationID()));
    }

    private void registrationCustomer() {
        repository.getUSER().add(new Customer(createLogin(), createPassword(), generationID()));
    }

    private String createLogin() {
        Scanner scanner = new Scanner(System.in);
        if (repository.getUSER().size() >= Repository.START_AMOUNT_USER) {
            System.out.println("Enter username");
            while (true) {
                String login = scanner.nextLine();
                if (login.length() == 6) {
                    return login;
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

    private String createPassword() {
        Scanner scanner = new Scanner(System.in);
        if (repository.getUSER().size() >= Repository.START_AMOUNT_USER) {
            System.out.println("Enter password");
            while (true) {
                String password = scanner.nextLine();
                if (password.length() == 6) {
                    return password;
                }
                System.out.println("Only 6 symbols");
            }
        }
        return generatePassword();
    }

    private String generatePassword() {
        char[] login = new char[6];
        for (int i = 0; i < login.length; i++) {
            login[i] = (char) (49 + Math.random() * 9);
        }
        return String.valueOf(login);
    }

    private int generationID() {
        return repository.getUSER().size() + 1;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username and password");
        while (true) {
            String login = scanner.nextLine().toUpperCase();
            String password = scanner.nextLine();
            for (int i = 0; i < repository.getUSER().size(); i++) {
                Verification.setCurrentUser(i);
                if (checkLogin(login) && checkPassword(password)) {
                    return;
                }
            }
            System.out.println("Incorrect username or password. Try again.");
        }
    }

    public boolean checkLogin(String login) {
        return repository.getUSER().get(Verification.getCurrentUser()).getLogin().compareTo(login) == 0;
    }

    public boolean checkPassword(String password) {
        return repository.getUSER().get(Verification.getCurrentUser()).getPassword().compareTo(password) == 0;
    }

    public void registrationNewUser() {
        registrationCustomer();
        System.out.println("Congratuletions! New user registered.");
    }

    public void searchByID() {
        if (repository.getUSER().get(Verification.getCurrentUser()) instanceof Administrator) {
            repository.searchUserByID();
            return;
        }
        System.out.println("Insufficient access rights. Only for administrators.");
    }

    public void showCustomers() {
        if (repository.getUSER().get(Verification.getCurrentUser()) instanceof Administrator) {
            repository.showCustomers();
            return;
        }
        System.out.println("Insufficient access rights. Only for administrators.");
    }

    public void showSuppliers() {
        if (repository.getUSER().get(Verification.getCurrentUser()) instanceof Administrator) {
            repository.showSuppliers();
            return;
        }
        System.out.println("Insufficient access rights. Only for administrators.");
    }

    public void showCurrentUser() {
        repository.showCurrentUser();
    }

    public void showListProductsCustomer() {
        if (repository.getUSER().get(Verification.getCurrentUser()) instanceof Customer) {
            repository.showListProductCustomers();
            return;
        }
        System.out.println("Insufficient access rights. Only for customers.");
    }

    public void showListProductsSuppliers() {
        if (repository.getUSER().get(Verification.getCurrentUser()) instanceof Supplier) {
            repository.showListProductSuppliers();
            return;
        }
        System.out.println("Insufficient access rights. Only for suppliers.");
    }
}
