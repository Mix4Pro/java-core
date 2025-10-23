package lesson12.StreamAPI.ForLoopFunctions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find the most expensive product of each category of the list
public class Task_10 {
    public static void main(String[] args) {
        record Product(String name, String category, double price) {}
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0));

        HashMap<String, Product> theMostExpensive = new HashMap<>();

        for (Product product : products) {
            Product temp_product = theMostExpensive.get(product.category());

            if (temp_product == null || product.price() > temp_product.price()) {
                theMostExpensive.put(product.category(), product);
            }
        }

        for (Map.Entry<String, Product> product : theMostExpensive.entrySet()) {
            System.out.println("Category : " + product.getKey());
            System.out.println("Name : " + product.getValue().name + " price : " + product.getValue().price);

            System.out.println();
        }
    }
}
