public class ProductFilterByManufacturer implements ProductFilter {

    private String manufacturer;

    public ProductFilterByManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(Product product) {
        return product.getManufacturer().equals(manufacturer);
    }

}