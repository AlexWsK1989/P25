package org.skypro.skyshop.product;
    public class FixPriceProduct extends Product {
        private static final double FIXED_PRICE = 999.99;

        public FixPriceProduct(String name) {
            super(name);
        }

        @Override
        public double getPrice() {
            return FIXED_PRICE;
        }

        @Override
        public boolean isSpecial() {
            return true;
        }

        public static double getFixedPrice() {
            return FIXED_PRICE;
        }

        @Override
        public String toString() {
            return String.format("%s: Фиксированная цена %.2f", getName(), FIXED_PRICE);
        }
    }

