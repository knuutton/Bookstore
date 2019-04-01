package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookstoreRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository, CategoryRepository catrepository) {
		return (args) -> {
			
			catrepository.save(new Category("Comedy"));
			catrepository.save(new Category("Study"));
			catrepository.save(new Category("IT"));
			
			repository.save(new Book("Matti", "Kirjoittaja", "123456", 2010, 15.90, catrepository.findByName("IT").get(0)));
			repository.save(new Book("Maija", "Kustantaja", "654321", 2011, 17.90, catrepository.findByName("IT").get(0)));
			
			

		};
	}

}
