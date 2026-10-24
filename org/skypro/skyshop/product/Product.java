package org.skypro.skyshop.product;


import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getSearchTerm() {
        // По условию: возвращаем имя товара
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // toString оставляем для вывода в корзине, как требует условие
    @Override
    public String toString() {
        return name + " — " + price + " руб.";
    }
}


        




