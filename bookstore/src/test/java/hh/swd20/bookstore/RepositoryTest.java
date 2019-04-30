package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookstoreRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	private BookstoreRepository bookrepository;

	@Autowired
	private CategoryRepository categoryrepository;

	// Book testaus
	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = bookrepository.findByAuthor("Kirjoittaja");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Matti");
	}

	// Category testaus
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = categoryrepository.findByName("IT");

		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("IT");
	}

	// Kirjan lisäys
	@Test
	public void addNewBook() {
		Book book = new Book("Mickey", "Mouse", "123456789", 2011, 19.50, new Category("1"));
		bookrepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	// Kirjan poisto
	@Test
	public void deleteBook() {
		long bookId = 4;
		bookrepository.deleteById(bookId);
	}

	// Kategorian poisto
	@Test
	public void deleteCategory() {
		long categoryId = 1;
		categoryrepository.deleteById(categoryId);
	}

	// Kategorian lisäys
	@Test
	public void addCategory() {
		Category category = new Category("Drama");
		categoryrepository.save(category);
		assertThat(category.getId()).isNotNull();
	}

}
