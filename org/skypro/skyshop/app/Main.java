package org.skypro.skyshop.app;

import org.skypro.skyshop.model.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


import java.awt.print.Book;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем движок поиска
        SearchEngine engine = new SearchEngine(10);

        // 2. Создаем и добавляем товары (наследники Product)


        Product phone = new Product("iPhone 15 Pro", 120000) {}; // Анонимный класс для примера
        Product laptop = new Product("MacBook Pro 14", 250000) {};



        engine.add(phone);
        engine.add(laptop);

        // 3. Создаем и добавляем статьи
        Article article1 = new Article("Как выбрать первый ноутбук для программирования",
                "Выбор первого устройства — важный шаг. В этой статье мы разберем...");
        Article article2 = new Article("Обзор iPhone 15 Pro: стоит ли обновляться?",
                "Вышел новый флагман Apple. Камеры стали лучше, но так ли это критично...");
        Article article3 = new Article("Принципы SOLID на пальцах",
                "Разбираем базовые принципы объектно-ориентированного дизайна...");

        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        // 4. Демонстрация поиска

        System.out.println("=== Поиск по слову 'код' ===");
        printResults(engine.search("код"));

        System.out.println("\n=== Поиск по слову 'iPhone' ===");
        printResults(engine.search("iPhone"));

        System.out.println("\n=== Поиск по слову 'ноутбук' ===");
        printResults(engine.search("ноутбук"));

        System.out.println("\n=== Поиск по слову 'принципы' ===");
        printResults(engine.search("принципы"));
    }

    private static void printResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}
