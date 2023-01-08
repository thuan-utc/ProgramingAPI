package program.api.majorAssignment.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "author is mandatory")
    private String author;
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "description is mandatory")
    private String description;
    @NotBlank(message = "content is mandatory")
    private String content;
    @NotNull(message = "post date is mandatory")
    private Instant postDate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_username", referencedColumnName = "username")
    private Author postAuthor;

    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && author.equals(post.author) && title.equals(post.title) && description.equals(post.description) && content.equals(post.content) && postDate.equals(post.postDate) && postAuthor.equals(post.postAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, description, content, postDate, postAuthor);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public Author getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Author postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Post(int id, String author, String title, String description, String content, Instant postDate, Author postAuthor) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;
        this.postDate = postDate;
        this.postAuthor = postAuthor;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                ", postAuthor=" + postAuthor +
                '}';
    }
}
