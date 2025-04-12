package nl.maikkingma.clean_hexagonal_onion.command.author;

import nl.maikkingma.clean_hexagonal_onion.domain.author.Author;
import nl.maikkingma.clean_hexagonal_onion.domain.author.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AuthorCommands {

    private final AuthorService authorService;

    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors/commands/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody RegisterAuthorDTO registerAuthorDTO) {
        authorService.registerAuthor(
                Author.createAuthor(registerAuthorDTO.firstName(), registerAuthorDTO.lastName())
        );
    }
}
