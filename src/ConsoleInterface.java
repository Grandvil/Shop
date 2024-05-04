import java.util.List;
import java.util.Scanner;

// Консольный интерфейс взаимодействия с программой

/*
Применение принципов SOLID:
* SRP: Класс ConsoleInterface отвечает за обработку взаимодействия с пользователем и делегирование действий соответствующим классам.
* DIP: Класс зависит от абстракций, таких как ProductCatalog, ShoppingCart, DeliverySystem и RatingSystem, а не от конкретных реализаций.
 */
public class ConsoleInterface {

    private ProductCatalog catalog;
    private ShoppingCart cart;
    private DeliverySystem deliverySystem;
    private RatingSystem ratingSystem;
    private OrderRepository orderRepository;
    private Scanner scanner;

    public ConsoleInterface() {
        catalog = new ProductCatalog();
        cart = new ShoppingCart();
        deliverySystem = new DeliverySystem();
        ratingSystem = new RatingSystem();
        orderRepository = new OrderRepository(); // Создан экземпляр OrderRepository
        scanner = new Scanner(System.in);
    }

    // Меню основных опций
    private void displayMainMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Вывести список доступных товаров");
        System.out.println("2. Фильтровать товары");
        System.out.println("3. Просмотреть корзину");
        System.out.println("4. Оформить заказ");
        System.out.println("5. Отследить заказ");
        System.out.println("6. Добавить товар в корзину");
        System.out.println("7. Оставить отзыв о товаре");
        System.out.println("8. Получить рекомендации по товарам");
        System.out.println("9. Выход");
        System.out.print("Введите номер опции: ");

    }

    public void run() {
        int option;
        do {
            displayMainMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    filterProducts();
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    trackOrder();
                    break;
                case 6:
                    addToCart(); // Вызов функции добавления товара в корзину
                    break;
                case 7:
                    leaveReview();
                    break;
                case 8:
                    getRecommendations();
                    break;
                case 9:
                    System.out.println("Спасибо за использование программы!");
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите опцию из меню.");
            }
        } while (option != 9);
    }

    // Вспомогательный метод displayFilteredProducts повторно используется для выполнения общей задачи отображения списка продуктов, что соответствует принципу DRY.
    private void displayProducts() {
        displayFilteredProducts(catalog.getAllProducts());
    }

    // Подменю фильтрации товаров
    private void filterProducts() {
        if (catalog.getAllProducts().isEmpty()) {
            System.out.println("Каталог товаров пуст.");
            return;
        }
        // Добавленная часть кода
        System.out.println("Фильтрация товаров:");
        System.out.println("1. По ключевым словам");
        System.out.println("2. По ценовому диапазону");
        System.out.println("3. По производителю");
        System.out.print("Введите номер опции фильтрации: ");
        int filterOption = scanner.nextInt();

        switch (filterOption) {
            case 1:
                filterProductsByKeyword();
                break;
            case 2:
                filterProductsByPriceRange();
                break;
            case 3:
                filterProductsByManufacturer();
                break;
            default:
                System.out.println("Неверный ввод. Пожалуйста, выберите опцию фильтрации из меню.");
        }
    }

    private void displayCart() {
        System.out.println("Ваша корзина:");
        for (ShoppingCartItem item : cart.getItems()) {
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity());
        }
        System.out.println("Общая стоимость: " + cart.getTotalPrice());
    }

    // Подменю оформления заказа
    private void checkout() {
        System.out.println("Оформление заказа:");
        System.out.println("1. Подтвердить заказ");
        System.out.println("2. Назад в главное меню");
        System.out.print("Введите номер опции: ");
        int checkoutOption = scanner.nextInt();

        switch (checkoutOption) {
            case 1:
                Order order = new Order();
                order.setItems(cart.getItems());
                order.setTotalPrice(cart.getTotalPrice());
                String orderId = deliverySystem.createOrder(order);
                System.out.println("Ваш заказ оформлен. Идентификатор заказа: " + orderId);
                cart.clear();
                break;
            case 2:
                // Вернуться в главное меню
                break;
            default:
                System.out.println("Неверный ввод. Пожалуйста, выберите опцию из меню.");
        }
    }

    // Подменю отслеживания заказа
    private void trackOrder() {
        System.out.println("Отслеживание заказа:");
        System.out.print("Введите идентификатор заказа: ");
        scanner.nextLine();
        String orderId = scanner.nextLine();
        String status = deliverySystem.trackOrder(orderId);
        System.out.println("Статус заказа: " + status);
    }

    // Подменю оставления отзыва о товаре
    private void leaveReview() {
        System.out.println("Оставить отзыв о товаре:");
        System.out.print("Введите название товара: ");
        scanner.nextLine();
        String productId = scanner.nextLine();
        Product product = catalog.getProduct(productId);
        if (product == null) {
            System.out.println("Товар с таким названием не найден.");
        } else {
            System.out.print("Введите рейтинг (от 1 до 5): ");
            int rating = scanner.nextInt();
            ratingSystem.addRating(product, rating);
            System.out.println("Ваш отзыв успешно добавлен.");
        }
    }

    // Подменю получения рекомендаций по товарам
    private void getRecommendations() {
        System.out.println("Получить рекомендации по товарам:");
        System.out.print("Введите название товара: ");
        scanner.nextLine();
        String productId = scanner.nextLine();
        Product product = catalog.getProduct(productId);
        if (product == null) {
            System.out.println("Товар с таким названием не найден.");
        } else {
            System.out.println("Оценка продукта:");
            System.out.println(ratingSystem.getAverageRating(product));
        }
    }

    private void filterProductsByKeyword() {
        System.out.print("Введите ключевое слово: ");
        scanner.nextLine(); // Ожидаем ввода ключевого слова
        String keyword = scanner.nextLine();
        List<Product> filteredProducts = catalog.filterProducts(new ProductFilterByKeyword(keyword));
        if (!filteredProducts.isEmpty()) {
            displayFilteredProducts(filteredProducts);
        } else {
            System.out.println("Соответствующих товаров не найдено.");
        }
    }


    private void filterProductsByManufacturer() {
        System.out.print("Введите производителя: ");
        scanner.nextLine(); // Ожидаем ввода производителя
        String manufacturer = scanner.nextLine();
        List<Product> filteredProducts = catalog.filterProducts(new ProductFilterByManufacturer(manufacturer));
        if (!filteredProducts.isEmpty()) {
            displayFilteredProducts(filteredProducts);
        } else {
            System.out.println("Соответствующих товаров не найдено.");
        }
    }


    private void filterProductsByPriceRange() {
        System.out.print("Введите минимальную цену: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Введите максимальную цену: ");
        double maxPrice = scanner.nextDouble();
        List<Product> filteredProducts = catalog.filterProducts(new ProductFilterByPriceRange(minPrice, maxPrice));
        if (!filteredProducts.isEmpty()) {
            displayFilteredProducts(filteredProducts);
        } else {
            System.out.println("Соответствующих товаров не найдено.");
        }
    }

    private void displayFilteredProducts(List<Product> filteredProducts) {
        if (filteredProducts.isEmpty()) {
            System.out.println("Соответствующих товаров не найдено.");
        } else {
            System.out.println("Отфильтрованные товары:");
            for (Product product : filteredProducts) {
                System.out.println(product.getName() + " - " + product.getPrice() + " - " + product.getManufacturer());
            }
        }
    }

    private void addToCart() {
        System.out.print("Введите название товара, который вы хотите добавить в корзину: ");
        scanner.nextLine();
        String productName = scanner.nextLine();
        Product product = catalog.getProduct(productName);
        if (product == null) {
            System.out.println("Товар с таким названием не найден.");
        } else {
            System.out.print("Введите количество товара, которое вы хотите добавить: ");
            int quantity = scanner.nextInt();
            cart.addItem(product, quantity);
            System.out.println("Товар добавлен в корзину.");
        }
    }

}
