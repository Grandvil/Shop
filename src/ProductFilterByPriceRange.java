public class ProductFilterByPriceRange implements ProductFilter {

    // Пример использования принципа избегания магических чисел
    private double minPrice;
    private double maxPrice;

    public ProductFilterByPriceRange(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean matches(Product product) {
        return product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
    }

}
