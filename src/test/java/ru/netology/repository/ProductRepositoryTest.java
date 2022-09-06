package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTest {
    Product book1 = new Book(1, "Испытание ядом", 190, "Мария Снайдер");
    Product book2 = new Book(2, "Девушка с нижнего этажа", 692, "Стейси Ли");
    Product book3 = new Book(3, "Магистериум", 522, "Блэк Холли,Кассандра Клэр");

    Product smartphone1 = new Smartphone(11, "A350 MIX 32 ГБ синий", 3_799, "DEXP");
    Product smartphone2 = new Smartphone(22, "Galaxy A03s 64 ГБ синий", 11_999, "Samsung");
    Product smartphone3 = new Smartphone(33, "Nokia X10 128 ГБ зеленый", 25_999, "Nokia");

    @Test
    public void saveAndRemoveTest() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(22);
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }
}