package nl.maikkingma.clean_hexagonal_onion.data.author;

import nl.maikkingma.clean_hexagonal_onion.domain.author.Author;

public class AuthorMapper {
    public static AuthorJPA mapToJPA(Author author) {
        return AuthorJPA.builder()
                .firstName(author.firstName())
                .lastName(author.lastName())
                .build();
    }

    public static Author mapFromJpa(AuthorJPA authorJPA) {
        return Author.builder()
                .id(authorJPA.getId())
                .firstName(authorJPA.getFirstName())
                .lastName(authorJPA.getLastName())
                .build();
    }
}
