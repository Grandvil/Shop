public class ProductFilterByKeyword implements ProductFilter {

    private String keyword;

    public ProductFilterByKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(Product product) {
        return product.getName().toLowerCase().contains(keyword.toLowerCase());
    }

}