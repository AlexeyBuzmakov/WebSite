import users.Administrator;
import users.Customer;
import users.Supplier;
import users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Repository{
    public static final ArrayList<User>USER = new ArrayList<>();
    private static int countAdministrator = 3;
    private static int countSupplier = 15;
    private static int countCustomer = 82;

    public void repository() {
        Site site = new Site();
        for(int i = 0; i < countAdministrator; i++) {
            USER.add(site.saveAdministrator());
        }
        for(int i = 0; i < countSupplier; i++) {
            USER.add(site.saveSupplier());
        }
        for(int i = 0; i < countCustomer; i++) {
            USER.add(site.saveCustomer());
        }
        System.out.println(USER);
    }

    public void searchUser() {
        System.out.println("Введите ID для поиска");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        for(User user : USER) {
            if(user.getID() == ID) {
                System.out.println(user);
            }
        }
    }

    public void printCustomers() {
        int n = 0;
        User[]customer = new Customer[countCustomer];
        for(int i = 0; i < USER.size(); i++) {
            if(USER.get(i) instanceof Customer) {
                customer[n] = USER.get(i);
                n++;
            }
        }
        System.out.println(Arrays.toString(customer));
    }

    public void printSuppliers() {
        int n = 0;
        User[]suppliers = new Supplier[countSupplier];
        for(int i = 0; i < USER.size(); i++) {
            if(USER.get(i) instanceof Supplier) {
                suppliers[n] = USER.get(i);
                n++;
            }
        }
        System.out.println(Arrays.toString(suppliers));
    }

//    public String printInfoUsers() {
//        for(int i = 0; i < )
//        return "Administrators: " + countAdministrator + " Suppliers: " + countSupplier + " Customers: " + countCustomer;
//    }
}
