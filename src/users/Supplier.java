package users;

import java.util.ArrayList;
import java.util.Random;

public class Supplier extends User{
    private ArrayList<String> listProduct = new ArrayList<>();
    private static int amountSupplier;

    public Supplier(String login, int password, int ID) {
        super(login, password, ID);
        amountSupplier++;
        listProduct = getListProduct();
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
        Random random = new Random();
        for(int i = 0; i < random.nextInt(6); i++) {
            listProduct.add("Product: " + product() + " amount: " + (int)(2 + Math.random() * 10) + " price: "
                    + (int)(30 + Math.random() * 1000) + " $");
        }
        return listProduct;
    }

    private String product() {
        Random random = new Random();
        String[]product = {"Shirt", "Jeans", "Jacket", "Bed", "Sofa", "Table", "Kettle", "Computer", "Refrigerator",
                "TV", "Phone", "Ball", "Wardrobe", "Jacket", "Pen", "Machine", "Pencil", "Tape", "Recorder", "Instruments"};
        return product[random.nextInt(product.length - 1)];
    }

    @Override
    public String toString() {
        return "User: Supplier " + "Login: " + getLogin() + " Password: " + getPassword() + " ID: " + getID();
    }
}
