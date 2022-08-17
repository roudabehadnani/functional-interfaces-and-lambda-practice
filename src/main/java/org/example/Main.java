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

    static Conditional<Product> findByStockZero = p -> p.getStock() == 0;

    static Conditional<Product> findByStartByB = p -> p.getProductName().startsWith("B");

    static Conditional<Product> findLowerThan150UpperThan100 = p -> p.getPrice() >= 100 && p.getPrice() <= 150;

    static Conditional<Product> findByStockLessThan10Above0 = p -> p.getStock() < 10 && p.getStock() > 0 ;


    public static void find(Collection<Product> source, Conditional<Product> conditional, Action<Product> action){
        for (Product p: source) {
            if (conditional.test(p)){
                action.execute(p);
            }
        }
    }


    public static void main(String[] args) {

        List<Product> afterFilter = new ArrayList<>();
        List<Product> listAfterFilter = new ArrayList<>();

        find(productList, findByStockZero, p -> System.out.println(p) );
        find(productList, findByStartByB, p -> System.out.println(p.getProductName()));
        find(productList, findLowerThan150UpperThan100, p -> afterFilter.add(p));
        System.out.println(afterFilter);
//        find(productList, findByStockLessThan10Above0, p -> System.out.println((p.getPrice() + 0.5 * p.getPrice())));
        find(productList, findByStockLessThan10Above0, p -> listAfterFilter.add(p));
        listAfterFilter.forEach(product -> product.setPrice(product.getPrice() + 0.5 * product.getPrice()));
        System.out.println(listAfterFilter);

//        for (Product o: listAfterFilter) {
//            double a = o.getPrice() + 0.5* o.getPrice();
//            o.setPrice(a);
//            System.out.println(o);
//
//        }
    }

}