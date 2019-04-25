package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookstoreRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository, CategoryRepository catrepository,
			UserRepository urepository) {
		return (args) -> {

			log.info("Save couple categories");
			catrepository.save(new Category("Comedy"));
			catrepository.save(new Category("Study"));
			catrepository.save(new Category("IT"));

			log.info("Save couple books");
			repository.save(
					new Book("Matti", "Kirjoittaja", "123456", 2010, 15.90, catrepository.findByName("IT").get(0)));
			repository.save(
					new Book("Maija", "Kustantaja", "654321", 2011, 17.90, catrepository.findByName("Study").get(0)));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for(Book books : repository.findAll()) {
			log.info(books.toString());
			}

		};
		
			
	}

}
