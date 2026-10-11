package org.skypro.skyshop.product;
    public class DiscountedProduct extends Product {
        private double basePrice;
        private int discountPercent;

        public DiscountedProduct(String name, double basePrice, int discountPercent) {
            super(name);
            this.basePrice = basePrice;
            this.discountPercent = discountPercent;
        }

        @Override
        public double getPrice() {
            double discountAmount = basePrice * discountPercent / 100.0;
            return basePrice - discountAmount;
        }

        @Override
        public boolean isSpecial() {
            return true;
        }

        public int getDiscountPercent() {
            return discountPercent;
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f (%d%%)", getName(), getPrice(), discountPercent);
        }
    }

