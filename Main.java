import java.util.List;

public class Main {
        public static <Product> void main(String[] args) {
            // --- Демонстрация ProductBasket ---
            ProductBasket basket = new ProductBasket();
            basket.addProduct(new Product("Яблоко", 100));
            basket.addProduct(new Product("Хлеб", 50));
            basket.addProduct(new Product("Яблоко", 120)); // Добавляем второй "Яблоко" с другой ценой
            basket.addProduct(new Product("Молоко", 80));

            System.out.println("Исходная корзина:");
            basket.printBasket();
            System.out.println();

            // Сценарий 1: Удаление существующего продукта
            System.out.println("Удаляем продукт 'Яблоко':");
            List<Product> removedApples = (List<Product>) basket.removeProductsByName("Яблоко");

            System.out.println("Удаленные продукты:");
            for (Product p : removedApples) {
                System.out.println("- " + p.getName() + " (Цена: " + p.getPrice() + ")");
            }
            System.out.println();

            System.out.println("Корзина после удаления яблок:");
            basket.printBasket();
            System.out.println();

            // Сценарий 2: Удаление несуществующего продукта
            System.out.println("Пытаемся удалить продукт 'Банан':");
            List<Product> removedBananas = basket.removeProductsByName("Банан");

            if (removedBananas.isEmpty()) {
                System.out.println("Список пуст");
            }
            System.out.println();

            System.out.println("Финальное состояние корзины:");
            basket.printBasket();
            System.out.println("\n=========================================\n");

            // --- Демонстрация SearchEngine ---
            SearchEngine engine = new SearchEngine();
            engine.addDocument(new Document("Введение в Java"));
            engine.addDocument(new Document("Продвинутый Python"));
            engine.addDocument(new Document("Основы Java"));
            engine.addDocument(new Документ("C++ для начинающих")); // Опечатка в названии класса для примера, должно быть Document
            engine.addDocument(new Document("Java Concurrency in Practice"));

            // Поиск по слову "Java" (раньше вернулось бы только 5, теперь вернутся все 3 подходящих)
            System.out.println("Поиск по запросу 'Java':");
            List<Document> javaResults = engine.search("Java");

            // Вывод списка результатов
            for (Document doc : javaResults) {
                System.out.println("- " + doc.getContent());
            }
            System.out.println("Всего найдено: " + javaResults.size());

            // Поиск по несуществующему запросу
            System.out.println("\nПоиск по запросу 'Golang':");
            List<Document> golangResults = engine.search("Golang");
            if (golangResults.isEmpty()) {
                System.out.println("Ничего не найдено.");
            }
        }
    }

