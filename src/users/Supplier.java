package users;

import java.util.ArrayList;
import java.util.Random;

public class Supplier extends User{
    private ArrayList<String> listProduct = new ArrayList<>();
    private static int amountSupplier;

    public Supplier(String login, String password, int ID) {
        super(login, password, ID);
        amountSupplier++;
        setListProduct(fillListProductSupplier());
    }

    public ArrayList<String> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<String> listProduct) {
        this.listProduct = listProduct;
    }

    public static int getAmountSupplier() {
        return amountSupplier;
    }

    public ArrayList<String> fillListProductSupplier() {
        for(int i = 0; i < (int)(1 + Math.random() * 5); i++) {
            listProduct.add("Product: " + product() + " Amount: " + (int)(1 + Math.random() * 10) + " Price: "
            + (int)(30 + Math.random() * 1000) + " $");
        }
        return listProduct;
    }

    private String product() {
        Random random = new Random();
        String[]product = {"Shirt", "Jeans", "Jacket", "Bed", "Sofa", "Table", "Kettle", "Computer", "Refrigerator",
        "TV", "Phone", "Ball", "Wardrobe", "Jacket", "Pen", "Machine", "Pencil", "Tape", "Recorder", "Instruments"};
        return product[random.nextInt(product.length)];
    }

    @Override
    public String toString() {
        return "User: Supplier " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
