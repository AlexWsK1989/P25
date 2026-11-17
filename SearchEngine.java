import java.util.TreeMap;
import java.util.Collection;

public class SearchEngine {
    // Допустим, здесь хранится общий список всех товаров в магазине
    private List<Searchable> allItems;

    // Новый метод поиска, возвращающий отсортированную мапу
    public Map<String, Searchable> searchToMap(String query) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Searchable item : allItems) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                // TreeMap автоматически отсортирует по ключу (имени)
                result.put(item.getName(), item);
            }
        }
        return result;
    }
}
