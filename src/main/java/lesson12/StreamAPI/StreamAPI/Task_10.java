package lesson12.StreamAPI.StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Find the most expensive product of each category of the list ( stream API )
public class Task_10 {
    public static void main(String[] args) {
        record Product(String name, String category, double price) {}
        List<Product> products = List.of(
            new Product("Phone", "Electronics", 1200),
            new Product("TV", "Electronics", 1800),
            new Product("Apple", "Fruits", 2.5),
            new Product("Mango", "Fruits", 4.0));


        Map<String, Product> theMostExpensive = products.stream().collect(Collectors.groupingBy(
            Product::category,
            Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::price)),
                Optional::get
            )
        ));

        for (Map.Entry<String, Product> product : theMostExpensive.entrySet()) {
            System.out.println("Category : " + product.getKey());
            System.out.println("Name : " + product.getValue().name + " price : " + product.getValue().price);

            System.out.println();
        }
    }
}
