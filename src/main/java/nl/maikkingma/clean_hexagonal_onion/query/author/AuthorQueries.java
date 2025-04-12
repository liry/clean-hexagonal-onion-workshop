package nl.maikkingma.clean_hexagonal_onion.query.author;

import java.util.List;
import java.util.stream.Collectors;

import nl.maikkingma.clean_hexagonal_onion.domain.author.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorQueries {

    private final AuthorService authorService;

    public AuthorQueries(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ResponseBody
    public List<AuthorView> getAll() {
        return authorService.findAll().stream().map(AuthorView::new).collect(Collectors.toList());
    }
}
