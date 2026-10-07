package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

    public class App {
        public static void main(String[] args) {
            // Создание продуктов
            Product apple = new Product("Яблоко", 100);
            Product bread = new Product("Хлеб", 50);
            Product milk = new Product("Молоко", 120);
            Product cheese = new Product("Сыр", 300);
            Product butter = new Product("Масло", 150);
            Product extra = new Product("Колбаса", 250);

            // Создание корзины
            ProductBasket basket = new ProductBasket();

            // 1. Добавление продуктов в корзину
            basket.addProduct(apple);
            basket.addProduct(bread);
            basket.addProduct(milk);
            basket.addProduct(cheese);
            basket.addProduct(butter);

            // 2. Попытка добавить продукт в заполненную корзину
            basket.addProduct(extra);

            // 3. Печать содержимого корзины
            System.out.println("--- Содержимое корзины ---");
            basket.printBasket();

            // 4. Получение стоимости корзины
            System.out.println("--- Расчет стоимости ---");
            System.out.println("Общая стоимость: " + basket.getTotalPrice());

            // 5. Поиск товара, который есть в корзине
            System.out.println("--- Поиск товаров ---");
            System.out.println("Есть ли 'Хлеб'? " + basket.containsProduct("Хлеб"));

            // 6. Поиск товара, которого нет в корзине
            System.out.println("Есть ли 'Колбаса'? " + basket.containsProduct("Колбаса"));

            // 7. Очистка корзины
            System.out.println("--- Очистка корзины ---");
            basket.clear();

            // 8. Печать содержимого пустой корзины
            basket.printBasket();

            // 9. Получение стоимости пустой корзины
            System.out.println("Общая стоимость: " + basket.getTotalPrice());

            // 10. Поиск товара по имени в пустой корзине
            System.out.println("Есть ли 'Яблоко'? " + basket.containsProduct("Яблоко"));
        }
    }

