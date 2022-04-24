package menu;

import data.Site;
import java.util.Scanner;

public class Menu {
    private final String[]menu = new String[9];

    Site site = new Site();

    public void Start() {
    site.createRepository();
    site.showRepository();
    site.input();
    showMenu();
    useMenu();
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
        Scanner scanner = new Scanner(System.in);
        while(true) {
            switch (scanner.nextLine().toUpperCase()) {
                case "1" -> site.registrationNewUser();
                case "2" -> site.searchByID();
                case "3" -> site.showCustomers();
                case "4" -> site.showSuppliers();
                case "5" -> site.showCurrentUser();
                case "6" -> site.showListProductsCustomer();
                case "7" -> site.showListProductsSuppliers();
                case "END" -> {System.out.println("EXIT"); return;}
                default -> System.out.println("Incorrection input. Try again");
                }
                System.out.println();
                showMenu();
            }
        }
    }


