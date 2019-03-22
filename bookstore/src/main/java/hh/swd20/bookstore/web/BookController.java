package hh.swd20.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.bookstore.domain.BookstoreRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookstoreRepository repository;
	
	@GetMapping("/index")
	public String home(Model model) {
		model.addAttribute("books", repository.findAll());
		return "index";
	}
}
