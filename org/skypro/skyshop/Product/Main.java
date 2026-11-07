package org.skypro.skyshop.Product;


    public class Main {
        public static void main(String[] args) {
            System.out.println("=== Демонстрация проверок в конструкторах Product ===");

            // 1. Проверка названия (пустая строка и пробелы)
            try {
                new SimpleProduct("", 100);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
            }

            try {
                new SimpleProduct("   ", 100);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
            }

            // 2. Проверка цены SimpleProduct (ноль и отрицательное)
            try {
                new SimpleProduct("Ноутбук", 0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
            }

            try {
                new SimpleProduct("Мышь", -50);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
            }

            // 3. Проверки DiscountedProduct
            try {
                new DiscountedProduct("Клавиатура", -1000, 10);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания DiscountedProduct: " + e.getMessage());
            }

            try {
                new DiscountedProduct("Монитор", 20000, -5);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания DiscountedProduct: " + e.getMessage());
            }

            try {
                new DiscountedProduct("Камера", 50000, 150);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка создания DiscountedProduct: " + e.getMessage());
            }

            System.out.println("\n=== Демонстрация поиска в SearchEngine ===");

            // Создаем валидные объекты для поиска
            Searchable[] catalog = new Searchable[]{
                    new SimpleProduct("Игровой ноутбук ASUS", 150000),
                    new DiscountedProduct("Беспроводная игровая мышь", 5000, 20),
                    new SimpleProduct("Механическая клавиатура для игр", 8000),
                    new SimpleProduct("Книга: Искусство программирования", 3000)
            };

            SearchEngine engine = new SearchEngine(catalog);

            // Сценарий 1: Объект существует
            try {
                Searchable result = engine.findBestMatch("игр");
                System.out.println("Найден наиболее подходящий элемент: " + result.getSearchTerm());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка поиска: " + e.getMessage());
            }

            // Сценарий 2: Объект не найден
            try {
                Searchable result = engine.findBestMatch("холодильник");
                System.out.println("Найден наиболее подходящий элемент: " + result.getSearchTerm());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка поиска: " + e.getMessage());
            }

            // Сценарий 3: Пустой поисковый запрос (демонстрация защиты в SearchEngine)
            try {
                Searchable result = engine.findBestMatch("   ");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка поиска: " + e.getMessage());
            } catch (BestResultNotFound e) {
                throw new RuntimeException(e);
            }
        }
    }

