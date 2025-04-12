package nl.maikkingma.clean_hexagonal_onion.domain.author;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    public void registerAuthor(Author author) {
        Author.createAuthor(author.firstName(), author.lastName());
    }
}
