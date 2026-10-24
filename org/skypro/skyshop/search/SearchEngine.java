package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

    public class SearchEngine {
        private final List<Searchable> items;

        public SearchEngine(int initialCapacity) {
            this.items = new ArrayList<>(initialCapacity);
        }

        public void add(Searchable item) {
            items.add(item);
        }

        public Searchable[] search(String query) {
            Searchable[] results = new Searchable[5];
            int foundCount = 0;

            for (Searchable item : items) {
                if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                    results[foundCount] = item;
                    foundCount++;

                    if (foundCount == 5) {
                        break;
                    }
                }
            }
            return results;
        }
    }

