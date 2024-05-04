import java.util.HashMap;
import java.util.Map;

// Класс для хранения заказов
public class OrderRepository {

    private Map<String, Order> orders; // Хранилище заказов, где ключ - идентификатор заказа, а значение - объект заказа

    public OrderRepository() {
        orders = new HashMap<>();
    }

    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    public Order findById(String orderId) {
        return orders.get(orderId);
    }
}
