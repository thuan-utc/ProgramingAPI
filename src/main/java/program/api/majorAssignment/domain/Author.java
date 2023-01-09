package program.api.majorAssignment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotBlank(message = "firtName is mandatory")
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    private String lastName;
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotNull(message = "Date of birth is mandatory")
    private Instant dob;
    @NotNull(message = "Time added is mandatory")
    private Instant added;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private final Set<Authority> authorities = new HashSet<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private final Set<Post> posts = new HashSet<>();

    public Author(String username, String password, String firtName, String lastName, String email, Instant dob, Instant added) {
        this.username = username;
        this.password = password;
        this.firstName = firtName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.added = added;
    }

    public Author() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getDob() {
        return dob;
    }

    public void setDob(Instant dob) {
        this.dob = dob;
    }

    public Instant getAdded() {
        return added;
    }

    public void setAdded(Instant added) {
        this.added = added;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return username.equals(author.username) && password.equals(author.password) && firstName.equals(author.firstName) && lastName.equals(author.lastName) && email.equals(author.email) && dob.equals(author.dob) && added.equals(author.added) && authorities.equals(author.authorities) && posts.equals(author.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, email, dob, added, authorities, posts);
    }

    @Override
    public String toString() {
        return "Author{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firtName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", added=" + added +
                ", authorities=" + authorities +
                ", posts=" + posts +
                '}';
    }
}
