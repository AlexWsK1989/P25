import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    // Было: private List<Product> products = new ArrayList<>();
    private final Map<String, List<Product>> productsByName = new HashMap<>();

    // Метод добавления товара
    public void addProduct(Product product) {
        // Вычисляем ключ один раз
        String key = product.getName();
        // Вычисляем хэш-код один раз для оптимизации
        int hash = key.hashCode();

        // getOrDefault здесь не всегда оптимален, лучше использовать computeIfAbsent
        // или явную проверку, чтобы не создавать лишние списки.
        List<Product> list = productsByName.get(key);
        if (list == null) {
            list = new ArrayList<>();
            productsByName.put(key, list);
        }
        list.add(product);
    }

    // Метод получения продуктов по имени (оптимизирован с O(n) до O(1))
    public List<Product> getProductsByName(String name) {
        // Возвращаем копию списка, чтобы защитить внутреннее состояние
        List<Product> original = productsByName.get(name);
        if (original == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(original);
    }

    // Метод удаления товара по имени
    public boolean removeProductByName(String name) {
        // remove возвращает значение (список продуктов) или null
        return productsByName.remove(name) != null;
    }

    // Метод печати содержимого корзины (с сортировкой)
    public void printBasket() {
        // 1. Получаем все ключи и сортируем их
        List<String> sortedNames = new ArrayList<>(productsByName.keySet());
        Collections.sort(sortedNames);

        System.out.println("Содержимое корзины:");
        for (String name : sortedNames) {
            List<Product> items = productsByName.get(name);
            // 2. Вложенный цикл по списку товаров с этим именем
            for (Product p : items) {
                System.out.println("- " + p.getName() + " (ID: " + p.getId() + ")");
            }
        }
    }

    // Если в классе был метод получения всех продуктов (например, для подсчета общей суммы),
    // его логика тоже меняется:
    public List<Product> getAllProducts() {
        List<Product> all = new ArrayList<>();
        for (List<Product> list : productsByName.values()) {
            all.addAll(list);
        }
        return all;
    }

    public <Product> List<Product> removeProductsByName(String яблоко) {
    }
}

