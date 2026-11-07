package org.skypro.skyshop.Product;


    public class BestResultNotFound extends Exception {
        public BestResultNotFound(String searchQuery) {
            super("Для поискового запроса '" + searchQuery + "' не нашлось подходящего элемента.");
        }
    }

