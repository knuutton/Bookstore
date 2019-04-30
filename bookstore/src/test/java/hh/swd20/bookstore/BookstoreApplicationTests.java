package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.web.BookController;
import hh.swd20.bookstore.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bcontroller;
	
	@Autowired
	private UserController ucontroller;
	
	
	   @Test
	    public void contextLoads() throws Exception {
	        assertThat(bcontroller).isNotNull();
	        assertThat(ucontroller).isNotNull();
	} 

}

