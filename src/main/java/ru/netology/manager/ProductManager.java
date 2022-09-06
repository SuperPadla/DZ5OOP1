package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository; //инициализация

    public ProductManager(ProductRepository repo) { // конструктор
        this.repository = repo;
    }

    public void add(Product product) { //  добавить продукт
        repository.add(product);
    }

    public Product[] findAll() { // показать все продукты
        Product[] products = repository.findAll();
        return products;
    }

    public void removeById(int id) { // удалить по id
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {  //  возвращает массив найденных товаров
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {  // проверяем соответствия
                Product[] tmp = new Product[result.length + 1]; // делаем новый массив длиннее на 1 ячейку
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;  //  "добавляем в конец" массива result продукт product
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) { // метод определения соответствия товара product запросу search
        if (product.getTitleProduct().contains(search)) {  //  проверяем вхождение запроса в текст названия товара
            return true;
        } else {
            return false;
        }
    }
}
