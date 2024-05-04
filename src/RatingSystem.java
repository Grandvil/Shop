import java.util.HashMap;
import java.util.Map;

// Управляет системой рейтингов для продуктов

/*
Применение принципов SOLID:
* SRP: Предназначен для управления системой рейтингов продуктов.
* OCP: Можно добавлять новые типы продуктов в систему рейтингов без изменения существующего кода.
* DIP: Зависит от абстракций, таких как Map<Product, Double> и Product, а не от конкретных реализаций продуктов и рейтингов.
 */
public class RatingSystem {

    private Map<Product, Double> productRatings;

    public RatingSystem() {
        productRatings = new HashMap<>();
    }

    public void addRating(Product product, double rating) {
        productRatings.put(product, rating);
    }

    public double getAverageRating(Product product) {
        return productRatings.getOrDefault(product, 0.0);
    }

}
