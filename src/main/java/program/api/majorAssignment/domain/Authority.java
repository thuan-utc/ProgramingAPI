package program.api.majorAssignment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;

@Entity
public class Authority {
    @Id
    @NotBlank(message = "userName is mandatory")
    @JsonProperty("authority_userName")
    private String userName;
    @NotBlank(message = "authority is mandatory")
    private String authority;
    //    @Id
//    @NotBlank(message = "userName is mandatory")
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_username", referencedColumnName = "username")
    private Author author;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Authority() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Authority{" +
                ", authority='" + authority + '\'' +
                ", author=" + author +
                '}';
    }
}
