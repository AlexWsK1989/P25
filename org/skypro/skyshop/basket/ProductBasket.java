
package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public int getSpecialProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printBasket() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.printf("Итого: %.2f%n", getTotalPrice());
        System.out.printf("Специальных товаров: %d%n", getSpecialProductCount());
    }
}


