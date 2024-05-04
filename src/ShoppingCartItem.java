/*
Применение принципов SOLID:
* SRP: Класс ShoppingCartItem отвечает за представление и управление информацией о товаре в корзине покупок.
* DIP: Зависит от абстракций, таких как Product, а не от конкретных реализаций продуктов.
 */
public class ShoppingCartItem {

    private Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}