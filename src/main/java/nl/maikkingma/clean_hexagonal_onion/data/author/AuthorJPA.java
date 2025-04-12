package nl.maikkingma.clean_hexagonal_onion.data.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class AuthorJPA {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "author_seq_gen")
    @SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq", allocationSize = 1)
    @Getter
    private Long id;
    @Getter
    private String firstName;
    @Getter
    private String lastName;

    public static AuthorJPABuilder builder() {
        return new AuthorJPABuilder();
    }

    public static class AuthorJPABuilder {

        private String firstName;
        private String lastName;

        public AuthorJPABuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AuthorJPABuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AuthorJPA build() {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("First name cannot be null or empty");
            }
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be null or empty");
            }
            return new AuthorJPA(null, firstName, lastName);
        }
    }
}
