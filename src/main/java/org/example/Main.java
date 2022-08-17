package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public class Main {


    static List<Product> productList = new ArrayList<>(
            Arrays.asList(
                    new Product("Painting book", 145, 20),
                    new Product("Pencil", 15, 50),
                    new Product("Book", 105, 6),
                    new Product("Ruler", 32, 0),
                    new Product("Water Color", 99, 12),
                    new Product("Note book", 45, 5),
                    new Product("Brush", 64, 10)
            )
    );

    static Conditional<Product> findByStockZero = p -> p.getStock() == 0;

    static Conditional<Product> findByStartByB = p -> p.getProductName().startsWith("B");

    static Conditional<Product> findLowerThan150UpperThan100 = p -> p.getPrice() >= 100 && p.getPrice() <= 150;

    static Conditional<Product> findByStockLessThan10Above0 = p -> p.getStock() < 10 && p.getStock() > 0;


    public static void find(Collection<Product> source, Conditional<Product> conditional, Action<Product> action){
        for (Product p: source) {
            if (conditional.test(p)){
                action.execute(p);
            }
        }
    }


    public static void main(String[] args) {

        List<Product> afterFilter = new ArrayList<>();

        find(productList, findByStockZero, product -> System.out.println(product) );
        find(productList, findByStartByB, product -> System.out.println(product.getProductName()));
        find(productList, findLowerThan150UpperThan100, product -> afterFilter.add(product));
        System.out.println(afterFilter);
        find(productList, findByStockLessThan10Above0, p -> System.out.println((p.getPrice() + 0.5 * p.getPrice())));
    }

}