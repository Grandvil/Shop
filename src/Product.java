import java.util.ArrayList;
import java.util.List;

// Класс отдельного товара

/*
Применение принципов SOLID:
* SRP: Отвечает за представление и управление информацией о продукте.
* OCP: Можно добавлять новые категории или типы отзывов без изменения существующего кода.
* LSP: Подклассы, такие как Book или Electronics, могут использоваться взаимозаменяемо с классом Product.
* DIP: Зависит от абстракций, таких как List и Review, а не от конкретных реализаций.
 */

public class Product {

    private String name;
    private String description;
    private double price;
    private String manufacturer;
    private List<String> categories;
    private int stockQuantity;
    private double averageRating;
    private List<Review> reviews;

    public Product(String name, String description, double price, String manufacturer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.categories = new ArrayList<>();
        this.stockQuantity = 0;
        this.averageRating = 0.0;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // Методы для добавления/удаления категорий
    public void addCategory(String category) {
        categories.add(category);
    }

    public void removeCategory(String category) {
        categories.remove(category);
    }

    // Методы для добавления/удаления отзывов
    public void addReview(Review review) {
        reviews.add(review);
        updateAverageRating();
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        updateAverageRating();
    }

    // Метод для обновления среднего рейтинга
    private void updateAverageRating() {
        if (reviews.isEmpty()) {
            averageRating = 0.0;
        } else {
            double totalRating = 0.0;
            for (Review review : reviews) {
                totalRating += review.getRating();
            }
            averageRating = totalRating / reviews.size();
        }
    }
}
