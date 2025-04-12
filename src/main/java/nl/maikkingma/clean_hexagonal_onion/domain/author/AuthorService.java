package nl.maikkingma.clean_hexagonal_onion.domain.author;

import java.util.List;

import nl.maikkingma.clean_hexagonal_onion.data.author.AuthorMapper;
import nl.maikkingma.clean_hexagonal_onion.data.author.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void registerAuthor(Author author) {
        authorRepository.save(AuthorMapper.mapToJPA(author));
    }

    public List<Author> findAll() {
        return authorRepository.findAll().stream()
                .map(authorJPA -> AuthorMapper.mapFromJpa(authorJPA))
                .toList();
    }
}
