package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    static Conditional findByStockZero = p -> p.getStock() == 0;

    static Conditional findByStartByB = p -> p.getProductName().startsWith("B");

    static Conditional findLowerThan150UpperThan100 = p -> p.getPrice() >= 100 && p.getPrice() <= 150;

    static Conditional findByStockLessThan10Above0 = p -> p.getStock() < 10 && p.getStock() > 0 ;

    static Action print = p -> System.out.println(p);

    static Action printName = p -> {
        System.out.println(p.getProductName());
    };

    static Action increaseAndPrint = p -> {
        p.setPrice(p.getPrice() * 1.5);
        System.out.println(p);
    };

    public static void findAndDo(Collection<Product> source, Conditional conditional, Action action){
        for (Product p: source) {
            if (conditional.test(p)){
                action.execute(p);
            }
        }
    }

    public static void main(String[] args) {

        findAndDo(productList, findByStockZero, print);
        findAndDo(productList, findByStartByB, printName);
        findAndDo(productList, findLowerThan150UpperThan100, print);
        findAndDo(productList, findByStockLessThan10Above0, increaseAndPrint);
    }
}