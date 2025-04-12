package nl.maikkingma.clean_hexagonal_onion.domain.author;

public record Author(Long id, String firstName, String lastName) {

    public static Author createAuthor(String firstName, String lastName) {
        return new Author(null, firstName, lastName);
    }
}
