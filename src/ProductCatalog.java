import java.util.ArrayList;
import java.util.List;

// Управляет каталогом продуктов и обеспечивает поиск и фильтрацию

/*
Применение принципов SOLID:
* SRP: Предназначен для управления каталогом продуктов и предоставления методов для поиска и фильтрации.
* OCP: Можно добавлять новые критерии фильтрации путем реализации новых подклассов ProductFilter, не изменяя класс ProductCatalog.
* LSP: Подклассы ProductFilter, такие как ProductFilterByKeyword или ProductFilterByPrice, могут использоваться взаимозаменяемо с классом ProductFilter.
* DIP: Зависит от абстракций, таких как List<Product> и ProductFilter, а не от конкретных реализаций.
 */
public class ProductCatalog {

    private List<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();

        Product product1 = new Product("Яблоко", "Описание товара 1", 10.0, "Производитель 1");
        Product product2 = new Product("Апельсин", "Описание товара 2", 15.0, "Производитель 2");
        Product product3 = new Product("Яйцо", "Описание товара 3", 20.0, "Производитель 3");
        Product product4 = new Product("Манго", "Описание товара 4", 25.0, "Производитель 4");
        Product product5 = new Product("Картофель", "Описание товара 5", 30.0, "Производитель 5");
        Product product6 = new Product("Молоко", "Описание товара 6", 35.0, "Производитель 6");
        Product product7 = new Product("Сок", "Описание товара 7", 40.0, "Производитель 7");
        Product product8 = new Product("Вода", "Описание товара 8", 45.0, "Производитель 8");
        Product product9 = new Product("Хлеб", "Описание товара 9", 50.0, "Производитель 9");
        Product product10 = new Product("Соль", "Описание товара 10", 55.0, "Производитель 10");

        addProduct(product1);
        addProduct(product2);
        addProduct(product3);
        addProduct(product4);
        addProduct(product5);
        addProduct(product6);
        addProduct(product7);
        addProduct(product8);
        addProduct(product9);
        addProduct(product10);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> filterProducts(ProductFilter filter) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (filter.matches(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
