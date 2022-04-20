
import users.Administrators;
import users.Customers;
import users.Suppliers;
import users.Users;

import java.util.ArrayList;

public class Site {

    public void registration() {
        ArrayList<Users>list = new ArrayList<>();
        for(int i = 0; i <= 100; i++) {
            if(i < 5) {
                list.add(new Administrators());
            }
            else if(i < 20) {
                list.add(new Suppliers());
            }
            else {
                list.add(new Customers());
            }
            System.out.println(list.get(i));
        }
    }
}
