package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepositoryRepository;

    public AuthorController(AuthorRepository authorRepositoryRepository) {
        this.authorRepositoryRepository = authorRepositoryRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepositoryRepository.findAll());
        return "authors/list";
    }
}
