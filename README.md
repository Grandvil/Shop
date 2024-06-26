# Магазин

В этой задаче практикуюсь с правилами чистого кода и принципами SOLID.

Написана программа-магазин, в которой пользователи заказывают товары. В процессе реализации применены принцип избегания магических чисел, DRY и принципы SOLID. 

Возможности программы:
* Вывод доступных для покупки товаров
* Фильтрация товаров по ключевым словам, ценам, производителям
* Составление продуктовой корзины пользователя
* Трекинг заказа в системе доставки
* Система рейтинга для товаров
* Простая рекомендательная система для покупок

Принципы, которые были применены, указаны явно комментариями в коде. Дополнительно ниже расписано самое основное:

1) Принцип DRY реализован в классе ConsoleInterface в методе displayProducts. Этот метод используется для отображения всех продуктов в каталоге, а также для отображения отфильтрованных продуктов. Вместо дублирования кода для этих двух случаев используется вспомогательный метод displayFilteredProducts.
2) Принцип избегания магических чисел реализован в классе ProductFilterByPriceRange. Вместо использования конкретных числовых значений для минимальной и максимальной цены используются параметры конструктора minPrice и maxPrice. Это делает код более понятным и поддерживаемым.
3) Реализация принципов SOLID:
* Принцип разделения интерфейса (ISP): Разбиваем интерфейс на несколько более мелких и специализированных интерфейсов, применяя его к интерфейсу ProductFilter.
* Принцип единственной ответственности (SRP): Каждый класс имеет единственную и хорошо определенную ответственность, например, класс Order отвечает за управление заказами.
* Принцип открытости-закрытости (OCP): Система проектируется таким образом, чтобы ее можно было расширять без необходимости модификации существующего кода, например, можно добавить новые критерии фильтрации без изменения ProductCatalog.
* Принцип подстановки Барбары Лисков (LSP): Подклассы должны быть взаимозаменяемы со своими родительскими классами, например, классы ProductFilterByKeyword, ProductFilterByPrice и ProductFilterByManufacturer могут использоваться взаимозаменяемо с ProductFilter.
* Принцип зависимости инверсии (DIP): Классы с высокой зависимостью должны зависеть от абстракций, а не от конкретных реализаций, например, класс ShoppingCart должен зависеть от интерфейса Product вместо конкретных подклассов продукта.
