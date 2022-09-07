package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

public class ProductManagerTest {
    Product book1 = new Book(1, "Испытание ядом", 190, "Мария Снайдер");
    Product book2 = new Book(2, "Девушка с нижнего этажа", 692, "Стейси Ли");
    Product book3 = new Book(3, "Истериум", 522, "Блэк Холли,Кассандра Клэр");

    Product smartphone1 = new Smartphone(11, "A350 MIX 32 ГБ синий", 3_799, "DEXP");
    Product smartphone2 = new Smartphone(22, "Galaxy A03s 64 ГБ синий", 11_999, "Samsung");
    Product smartphone3 = new Smartphone(33, "Nokia X10 128 ГБ зеленый", 25_999, "Nokia");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSearchByText() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Ис");
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("ki");
        Product[] expected = {smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBySearchId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(11);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBySearchId1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(11);
        manager.findAll();

        Product[] actual = manager.searchBy("lax");
        Product[] expected = {smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmpty() {
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTest() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("грибы");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}