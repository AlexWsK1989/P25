import java.util.List;

public class SearchEngine {
    public List<Document> search(String golang) {
    }import java.util.ArrayList;
import java.util.List;

    public class SearchEngine {
        private List<Document> documents;

        public SearchEngine() {
            this.documents = new ArrayList<>();
        }

        public void addDocument(Document doc) {
            documents.add(doc);
        }

        // Метод возвращает все найденные документы
        public List<Document> search(String query) {
            List<Document> results = new ArrayList<>();
            String lowerQuery = query.toLowerCase();

            for (Document doc : documents) {
                if (doc.getContent().toLowerCase().contains(lowerQuery)) {
                    results.add(doc);
                }
            }
            return results;
        }
    }
}
