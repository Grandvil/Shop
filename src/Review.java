// Отзыв о продукте

/*
Применение принципов SOLID:
* SRP: Класс Review отвечает за представление и управление информацией об отзывах.
* OCP: Можно добавлять новые типы отзывов без изменения существующего кода.
 */
public class Review {

    private String author;
    private double rating;
    private String comment;

    // Конструктор и геттеры/сеттеры

    public Review(String author, double rating, String comment) {
        this.author = author;
        this.rating = rating;
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}