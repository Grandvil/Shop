import java.util.UUID;

// Отслеживает и управляет доставкой заказов

/*
Применение принципов SOLID:
* SRP: Отвечает исключительно за отслеживание и управление доставкой заказов.
 */

public class DeliverySystem {

    // Добавлена переменная orderRepository
    private OrderRepository orderRepository;

    public DeliverySystem() {
        orderRepository = new OrderRepository();
    }

    public String trackOrder(String orderId) {
        // Имитировать отслеживание заказа и вернуть информацию о статусе
        return "Статус заказа: Доставлен";
    }

    public String createOrder(Order order) {
        // Генерируем уникальный идентификатор заказа
        String orderId = UUID.randomUUID().toString();

        // Сохраняем заказ в базе данных или используем другой механизм хранения
        orderRepository.save(order);

        // Возвращаем идентификатор заказа
        return orderId;
    }

}
