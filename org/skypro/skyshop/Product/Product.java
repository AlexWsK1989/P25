package org.skypro.skyshop.Product;


    public abstract class Product implements Searchable {
        private final String name;

        public Product(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
            }
            this.name = name;
        }

        @Override
        public String getSearchTerm() {
            return name;
        }

        public String getName() {
            return name;
        }
    }

