import java.util.Map;

SearchEngine engine = new SearchEngine();
// Если сигнатура search изменилась и возвращает Map:
Map<String, Searchable> results = engine.searchToMap("apple");

// Вариант 1: Обход по ключам (гарантирует сортировку, так как это TreeMap)
for (String name : results.keySet()) {
Searchable item = results.get(name);
    System.out.println(item.getName());
        }

// Вариант 2: Обход по записям (более идиоматичный для Map)
        for (
Map.Entry<String, Searchable> entry : results.entrySet()) {
        System.out.println("Найдено: " + entry.getKey() + " -> " + entry.getValue().getId());
        }

// Если сигнатуру search менять нельзя и она возвращает List:
// List<Searchable> results = engine.search("apple");
// Map<String, Searchable> sorted = new TreeMap<>();
// for (Searchable item : results) {
//     sorted.put(item.getName(), item);
// }
// for (String name : sorted.keySet()) {
//     System.out.println(sorted.get(name).getName());
// }
