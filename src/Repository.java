import users.User;

public class Repository {
    public static final int COUNT_USERS = 100;
    public static final User[]USER = new User[COUNT_USERS];
    public static final int COUNT_ADMINISTRATORS = 3;
    public static final int COUNT_SUPPLIERS = 15;
    public static final int COUNT_CUSTOMERS = COUNT_USERS - (COUNT_ADMINISTRATORS + COUNT_SUPPLIERS);


    public void repository() {
        Site site = new Site();
        for(int i = 0; i < COUNT_USERS; i++) {
            if(i < COUNT_ADMINISTRATORS) {
                USER[i] = site.saveAdministrator();
            }
            else if(i < COUNT_ADMINISTRATORS + COUNT_SUPPLIERS) {
                USER[i] = site.saveSupplier();
            }
            else {
                USER[i] = site.saveCustomer();
            }
            System.out.println(USER[i]);
        }
    }
}
