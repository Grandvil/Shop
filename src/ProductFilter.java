/*
Применение принципов SOLID:
* ISP: Интерфейс ProductFilter следует принципу разделения интерфейса, предоставляя только один метод для фильтрации продуктов.
* OCP: Можно добавлять новые критерии фильтрации путем реализации новых подклассов ProductFilter, не изменяя интерфейс ProductFilter.
* LSP: Подклассы ProductFilter, такие как ProductFilterByKeyword или ProductFilterByPrice, могут использоваться взаимозаменяемо с интерфейсом ProductFilter.
* DIP: Класс ProductCatalog зависит от абстракции ProductFilter, а не от конкретных реализаций критериев фильтрации.
 */

public interface ProductFilter {

    boolean matches(Product product);

}