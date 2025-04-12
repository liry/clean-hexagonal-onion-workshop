package nl.maikkingma.clean_hexagonal_onion.data.author;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface AuthorRepository extends Repository<AuthorJPA, Long> {

    void save(AuthorJPA authorJPA);

    void deleteAll();

    void flush();

    List<AuthorJPA> findAll();
}
