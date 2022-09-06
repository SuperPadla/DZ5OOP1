package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {  //  добавить(сохранить) продукт
        Product[] tmp = new Product[products.length + 1];  //  новый массив
        for (int i = 0; i < products.length; i++) {  //  перебираем ячейки
            tmp[i] = products[i];  // перезапись в соотв. ячейки
        }
        tmp[tmp.length - 1] = product;  // записываем новый продукт в последнюю ячейку нового массива
        products = tmp;  //  "обновляем" старый массив
    }

    public Product[] findAll() { // показать все сохраненные продукты
        return products;
    }

    public void removeById(int id) {  //  удалить по id
        int length = products.length - 1;  //  вычисляем количество ячеек массива
        Product[] tmp = new Product[length];  //  создаем новый массив
        int index = 0;                        // заводим счетчик для перехода по ячейкам
        for (Product product : products) {  // запускаем цикл
            if (product.getId() != id) {  // проверяем несовпадение id
                tmp[index] = product;  //  оставляем/перезаписываем в соотв. ячейке по счетчику
                index++;  //  прибавляем счетчик
            }  // иначе - пропускаем ячейку, соответственно ее уже не будет в новом массиве
        }
        products = tmp;  //  "обновляем" старый массив
    }
}