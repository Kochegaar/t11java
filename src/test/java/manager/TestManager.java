package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "King", 5, "Jipsy");
    Product book1 = new Book(2, "Rat", 55, "Ushinskiy");
    Product smartphone = new Smartphone(3, "HTC", 10_000, "LG");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("Jipsy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Rat");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("HTC");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneManufacturer() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("LG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFalse() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }
}