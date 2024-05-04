import java.util.ArrayList;
import java.util.List;

// Содержит список выбранных клиентом продуктов

/*
Применение принципов SOLID:
* SRP: Отвечает за управление списком выбранных пользователем продуктов.
* OCP: Можно добавлять новые типы продуктов без изменения существующего кода.
* DIP: Зависит от абстракций, таких как List<ShoppingCartItem> и Product, а не от конкретных реализаций.
 */
public class ShoppingCart {

    private List<ShoppingCartItem> items;
    private double totalPrice;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        ShoppingCartItem item = new ShoppingCartItem(product, quantity);
        items.add(item);
    }

    public void removeItem(Product product) {
        for (ShoppingCartItem item : items) {
            if (item.getProduct().equals(product)) {
                items.remove(item);
                break;
            }
        }
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ShoppingCartItem item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public void clear() {
        // Очищаем список элементов корзины
        items.clear();

        // Обновляем общую стоимость корзины
        totalPrice = 0.0;
    }

}
