
    import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class ProductBasket<Product> {
        private List<Product> products;

        public ProductBasket() {
            // Используем ArrayList для динамического изменения размера
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            // Проверка на невозможность добавления больше не нужна
            products.add(product);
        }

        // Метод удаления по имени
        public List<Product> removeProductsByName(String name) {
            List<Product> removed = new ArrayList<>();
            Iterator<Product> iterator = products.iterator();

            while (iterator.hasNext()) {
                Product p = iterator.next();
                if (p.getName().equals(name)) {
                    removed.add(p);
                    iterator.remove(); // Безопасное удаление через итератор
                }
            }
            return removed;
        }

        public void printBasket() {
            if (products.isEmpty()) {
                System.out.println("Корзина пуста.");
                return;
            }
            System.out.println("Содержимое корзины:");
            for (Product p : products) {
                System.out.println("- " + p.getName() + " (Цена: " + p.getPrice() + ")");
            }
        }
    }

