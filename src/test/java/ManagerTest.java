import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ManagerTest {

    @Test
    public void removeByIdTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(11, "Martin Eden", 100, "London");
        Book book2 = new Book(12, "The count of Monte Cristo", 200, "Dumas");
        Book book3 = new Book(13, "Robinzon Cruzoe", 300, "Defo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        repo.removeById(12);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNotExistIdTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(11, "Martin Eden", 100, "London");
        Book book2 = new Book(12, "The count of Monte Cristo", 200, "Dumas");
        Book book3 = new Book(13, "Robinzon Cruzoe", 300, "Defo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(25));
    }

    @Test
    public void addBookTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(11, "Martin Eden", 100, "London");
        Book book2 = new Book(12, "The count of Monte Cristo", 200, "Dumas");
        Book book3 = new Book(13, "Robinzon Cruzoe", 300, "Defo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSmartphoneTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(101, "Samsung S9", 51000, "Samsung");
        Smartphone smartphone2 = new Smartphone(102, "Vivo Y31", 21000, "Vivo");
        Smartphone smartphone3 = new Smartphone(103, "Honor 50", 47000, "Huawei");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addBookAndSmartphoneTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(101, "Samsung S9", 51000, "Samsung");
        Smartphone smartphone2 = new Smartphone(102, "Vivo Y31", 21000, "Vivo");
        Book book1 = new Book(11, "Martin Eden", 100, "London");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, book1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchWhenOneResultTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(11, "Martin Eden", 100, "London");
        Book book2 = new Book(12, "The count of Monte Cristo", 200, "Dumas");
        Book book3 = new Book(13, "Robinzon Cruzoe", 300, "Defo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Martin");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchWhenFewResultTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(11, "Martin Eden", 100, "London");
        Book book2 = new Book(12, "The count of Monte Cristo", 200, "Dumas");
        Book book3 = new Book(13, "Martin Cruzoe", 300, "Defo");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Martin");
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }


}
