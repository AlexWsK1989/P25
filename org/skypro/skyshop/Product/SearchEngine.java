package org.skypro.skyshop.Product;


    public class SearchEngine {
        private final Searchable[] items;

        public SearchEngine(Searchable[] items) {
            this.items = items;
        }

        public Searchable findBestMatch(String search) throws BestResultNotFound {
            if (search == null || search.isBlank()) {
                throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
            }

            Searchable bestMatch = null;
            int maxCount = -1;

            for (Searchable item : items) {
                // Обработка null в массиве (критерий оценки)
                if (item == null) {
                    continue;
                }

                String term = item.getSearchTerm();
                if (term == null) {
                    continue;
                }

                int count = countOccurrences(term.toLowerCase(), search.toLowerCase());
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }

            if (bestMatch == null || maxCount == 0) {
                throw new BestResultNotFound(search);
            }

            return bestMatch;
        }

        // Алгоритм из подсказки (пункт 3 задания)
        private int countOccurrences(String str, String substring) {
            int count = 0;
            int index = 0;
            int subIndex = str.indexOf(substring, index);

            while (subIndex != -1) {
                count++;
                index = subIndex + substring.length();
                subIndex = str.indexOf(substring, index);
            }
            return count;
        }
    }

