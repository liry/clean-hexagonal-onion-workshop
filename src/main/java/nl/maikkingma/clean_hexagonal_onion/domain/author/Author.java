package nl.maikkingma.clean_hexagonal_onion.domain.author;

import lombok.Builder;
import lombok.Getter;

@Builder
public record Author(@Getter Long id, String firstName, String lastName) {

    public static Author createAuthor(String firstName, String lastName) {
        return new Author(null, firstName, lastName);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
