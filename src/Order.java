import java.util.ArrayList;
import java.util.List;

// Представляет собой конкретный заказ, размещенный клиентом

/*
Применение принципов SOLID:
* SRP: Предназначен для представления и управления информацией о заказе.
* OCP: Можно добавлять новые типы продуктов в заказ без изменения существующего кода.
* DIP: Зависит от абстракций, таких как List<ShoppingCartItem>, а не от конкретных реализаций продуктов в корзине покупок.
 */

public class Order {

    private String id;
    private List<ShoppingCartItem> items;
    private double totalPrice;
    private String status; // Например: "Новый", "Обрабатывается", "Доставлен"

    public Order() {
        items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
