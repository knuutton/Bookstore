package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.apache.catalina.startup.ClassLoaderFactory.Repository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookstoreRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	//private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository) {
		return (args) -> {
			Book b1 =new Book("Matti", "Kirjoittaja", "123456", 2010, 15.90);
			Book b2 =new Book("Maija", "Kustantaja", "654321", 2011, 17.90);
			
			repository.save(b1);
			repository.save(b2);

		};
	}

}
