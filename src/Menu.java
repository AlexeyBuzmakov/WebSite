
import java.util.Scanner;

public class Menu {
    public static final String[]menu = new String[8];

    public void Start() {
    input();
    showMenu();
    useMenu();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter username and password");
            String login = scanner.nextLine();
            Integer password = scanner.nextInt();
            if (checkInput(login, password)) {
                break;
            } else {
                System.out.println("Incorrect login or password. Try again");
            }
        }
    }

    private boolean checkInput(String login, Integer password) {
        for(int i = 0; i < Repository.USER.size(); i++) {
            if(Repository.USER.get(i).getLogin().compareTo(login) == 0) {
                if(checkPassword(i, password)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkPassword(int i, Integer password) {
        return Repository.USER.get(i).getPassword().compareTo(password) == 0;
    }

    private void showMenu() {
        for (int i = 0; i < menu.length; i++) {
            switch (i) {
                case 1 -> menu[i] = "1. Register new user";
                case 2 -> menu[i] = "2. Get information users by ID";
                case 3 -> menu[i] = "3. Show list of customers (only for administrators)";
                case 4 -> menu[i] = "4. Show list of suppliers (only for administrators)";
                case 5 -> menu[i] = "5. Get information about current user";
                case 6 -> menu[i] = "6. Get list orders (only for customers)";
                case 7 -> menu[i] = "7. Get list products (only for suppliers)";
            }
            System.out.println(menu[i]);
        }
    }

    private void useMenu() {
        Site site = new Site();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
            switch(i) {
                case 1 -> site.createNewUser();
                case 2 -> menu[i] = "2. Get information users by ID";
                case 3 -> menu[i] = "3. Show list of customers (only for administrators)";
                case 4 -> menu[i] = "4. Show list of suppliers (only for administrators)";
                case 5 -> menu[i] = "5. Get information about current user";
                case 6 -> menu[i] = "6. Get list orders (only for customers)";
                case 7 -> menu[i] = "7. Get list products (only for suppliers)";
            }
        }
    }

