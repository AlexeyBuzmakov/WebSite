package menu;

import data.Repository;
import utils.Verification;
import java.util.Scanner;

public class Menu {
    private final String[]menu = new String[9];

    public void Start() {
    Repository repository = new Repository();
    repository.createRepository();
    repository.showRepository();
    input();
    showMenu();
    useMenu();
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username and password");
        while (true) {
            String login = scanner.nextLine().toUpperCase();
            String password = scanner.nextLine();
            for (int i = 0; i < Repository.USER.size(); i++) {
                Verification.setCurrentUser(i);
                if (checkLogin(login) && checkPassword(password)) {
                    return;
                }
            }
            System.out.println("Incorrect username or password. Try again.");
        }
    }

    private boolean checkLogin(String login) {
        return Repository.USER.get(Verification.getCurrentUser()).getLogin().compareTo(login) == 0;
    }

    private boolean checkPassword(String password) {
        return Repository.USER.get(Verification.getCurrentUser()).getPassword().compareTo(password) == 0;
    }

    private void showMenu() {
        for (int i = 0; i < menu.length - 1; i++) {
            switch (i) {
                case 0 -> menu[i] = "1. REGISTER NEW USER";
                case 1 -> menu[i] = "2. GET INFORMATION USERS BY ID (ONLY FOR ADMINISTRATOR)";
                case 2 -> menu[i] = "3. SHOW LIST OF CUSTOMERS (ONLY FOR ADMINISTRATOR)";
                case 3 -> menu[i] = "4. SHOW LIST OF SUPPLIERS (ONLY FOR ADMINISTRATOR)";
                case 4 -> menu[i] = "5. GET INFORMATION ABOUT CURRENT USER";
                case 5 -> menu[i] = "6. GET LIST ORDERS (ONLY FOR CUSTOMERS)";
                case 6 -> menu[i] = "7. GET LIST PRODUCTS (ONLY FOR SUPPLIERS)";
                case 7 -> menu[i] = "END. EXIT MAIN MENU";
            }
            System.out.println(menu[i]);
        }
    }

    private void useMenu() {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            switch (scanner.nextLine().toUpperCase()) {
                case "1" -> repository.addNewUser();
                case "2" -> repository.searchUserByID();
                case "3" -> repository.showCustomers();
                case "4" -> repository.showSuppliers();
                case "5" -> repository.showCurrentUser();
                case "6" -> repository.showListProductCustomers();
                case "7" -> repository.showListProductSuppliers();
                case "END" -> {System.out.println("EXIT"); return;}
                default -> System.out.println("Incorrection input. Try again");
                }
                System.out.println();
                showMenu();
            }
        }
    }


