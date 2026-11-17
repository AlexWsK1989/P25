package org.skypro.skyshop.Product;

public class SimpleProduct extends Product {
        private final double price;

        public SimpleProduct(String name, double price) {
            super(name);
            if (price <= 0) {
                throw new IllegalArgumentException("Цена простого продукта должна быть строго больше 0. Получено: " + price);
            }
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

