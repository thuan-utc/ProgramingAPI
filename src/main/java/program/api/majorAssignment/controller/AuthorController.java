package program.api.majorAssignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import program.api.majorAssignment.domain.Author;
import program.api.majorAssignment.exception.BusinessException;
import program.api.majorAssignment.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    private final Logger log = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/getAll")
    public Iterable<Author> getAllAuthors() {
        log.info("Getting all Authors");
        return authorService.getAllAuthors();
    }

    @PostMapping(path = "/create")
    public Author createAuthor(@Valid @RequestBody Author author) {
        if (!authorService.checkIfUserHasExited(author.getUsername())) {
            log.info("Saving author has username = {}", author.getUsername());
            return authorService.createAuthor(author);
        }
        throw new BusinessException("400 Bad request", "Create Author failed");
    }

    @PutMapping(path = "/update/{username}")
    public Author updateAuthor(@Valid @RequestBody Author author, @PathVariable String username) {
        if (authorService.checkIfUserHasExited(username)) {
            log.info("Updating author");
            return authorService.updateAuthor(author, username);
        }
        log.info("Can't find author has username = {}", username);
        throw new BusinessException("400 Bad request", "Update Author failed");
    }

    @DeleteMapping(path = "/delete/{username}")
    public void deleteAuthor(@PathVariable String username) {
        if (authorService.checkIfUserHasExited(username)) {
            authorService.deleteAuthor(username);
            log.info("Delete Author successfully");
            return;
        }
        log.info("Can't find author has username = {}", username);
        throw new BusinessException("400 Bad request", "Delete Author failed");
    }
}
