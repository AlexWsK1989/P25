package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
                public static void main(String[] args) {
                    ProductBasket basket = new ProductBasket();

                    // Обычный товар
                    Product keyboard = new SimpleProduct("Механическая клавиатура", 4500.00);

                    // Товар со скидкой
                    Product mouse = new DiscountedProduct("Беспроводная мышь", 2500.00, 15);

                    // Товар с фиксированной ценой
                    Product mug = new FixPriceProduct("Кружка с логотипом");

                    basket.addProduct(keyboard);
                    basket.addProduct(mouse);
                    basket.addProduct(mug);

                    basket.printBasket();
                }
            }


            // Создание продуктов