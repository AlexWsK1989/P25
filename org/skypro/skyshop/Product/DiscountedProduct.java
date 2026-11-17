package org.skypro.skyshop.Product;


    public class DiscountedProduct extends Product {
        private final double basePrice;
        private final double discountPercent;

        public DiscountedProduct(String name, double basePrice, double discountPercent) {
            super(name);
            if (basePrice <= 0) {
                throw new IllegalArgumentException("Базовая цена скидочного продукта должна быть строго больше 0. Получено: " + basePrice);
            }
            if (discountPercent < 0 || discountPercent > 100) {
                throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно. Получено: " + discountPercent);
            }
            this.basePrice = basePrice;
            this.discountPercent = discountPercent;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public double getDiscountPercent() {
            return discountPercent;
        }

        public double getFinalPrice() {
            return basePrice * (1 - discountPercent / 100);
        }
    }

