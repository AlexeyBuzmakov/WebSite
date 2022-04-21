package menu;

import data.Repository;
import utils.Verification;

import java.util.Scanner;

public class Menu {
    public static final String[]menu = new String[9];

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
        boolean successfully = false;
        while (!successfully) {
            String login = scanner.nextLine().toUpperCase();
            Integer password = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Repository.USER.size(); i++) {
                if (checkLogin(i, login) && checkPassword(i, password)) {
                    Verification.setCurrentUser(i);
                    successfully = true;
                }

            }
            if(!successfully) {
                System.out.println("Incorrect username or password. Try again.");
            }
        }
    }

    private boolean checkLogin(int i, String login) {
        return Repository.USER.get(i).getLogin().compareTo(login) == 0;
    }

    private boolean checkPassword(int i, Integer password) {
        return Repository.USER.get(i).getPassword().compareTo(password) == 0;
    }

    private void showMenu() {
        for (int i = 0; i < menu.length - 1; i++) {
            switch (i) {
                case 0 -> menu[i] = "1. Register new user";
                case 1 -> menu[i] = "2. Get information users by ID (only for administrators)";
                case 2 -> menu[i] = "3. Show list of customers (only for administrators)";
                case 3 -> menu[i] = "4. Show list of suppliers (only for administrators)";
                case 4 -> menu[i] = "5. Get information about current user";
                case 5 -> menu[i] = "6. Get list orders (only for customers)";
                case 6 -> menu[i] = "7. Get list products (only for suppliers)";
                case 7 -> menu[i] = "END for exit main menu";
            }
            System.out.println(menu[i]);
        }
        System.out.println();
    }

    private void useMenu() {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        boolean openMenu = true;
        while(openMenu) {
            switch (scanner.nextLine().toUpperCase()) {
                case "1" -> repository.addNewUser();
                case "2" -> repository.searchUserByID();
                case "3" -> repository.showCustomers();
                case "4" -> repository.showSuppliers();
                case "5" -> repository.showCurrentUser();
                case "6" -> repository.showListProductCustomers();
                case "7" -> repository.showListProductSuppliers();
                case "END" -> openMenu = closeMenu();
                default -> defaultMenu();
                }
                System.out.println();
                if(openMenu) {
                    showMenu();
                }
            }
        }

        private boolean closeMenu() {
            System.out.println("Exit");
            return false;
        }

        private void defaultMenu() {
            System.out.println("Incorrection input. Try again");
        }
    }


