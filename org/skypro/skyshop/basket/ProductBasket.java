
package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

    public class ProductBasket {
        private final Product[] items;

        public ProductBasket() {
            this.items = new Product[5];
        }

        public void addProduct(Product product) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = product;
                    return;
                }
            }
            System.out.println("Невозможно добавить продукт");
        }

        public int getTotalPrice() {
            int sum = 0;
            for (Product item : items) {
                if (item != null) {
                    sum += item.getPrice();
                }
            }
            return sum;
        }

        public void printBasket() {
            boolean isEmpty = true;
            for (Product item : items) {
                if (item != null) {
                    isEmpty = false;
                    System.out.println(item.getName() + ": " + item.getPrice());
                }
            }
            if (isEmpty) {
                System.out.println("в корзине пусто");
            } else {
                System.out.println("Итого: " + getTotalPrice());
            }
        }

        public boolean containsProduct(String name) {
            for (Product item : items) {
                if (item != null && item.getName().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            for (int i = 0; i < items.length; i++) {
                items[i] = null;
            }
        }
    }


