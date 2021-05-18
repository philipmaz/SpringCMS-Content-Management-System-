package springCMS.entity;


//    id
//    title (max. 200 znaków),
//    author - (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
//    categories - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
//    content
//    created (wartość ma być automatycznie dodawana podczas zapisu)
//    updated (wartość ma być automatycznie zmieniana podczas edycji).

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min=2,max=200, message = "Title: this field must contain at least 2 characters.")
    private String title;
    @NotNull(message = "Author: This field cannot be blank. Select author.")
    @OneToOne
    private Author author;
    @NotEmpty(message = "Category: This field cannot be blank. Select at least one category.")
    @ManyToMany
    private List<Category> categories;
    @Size(min=10,max=6000, message = "Content: this field must contain at least 10 characters.")
    private String content;
    private String created;
    private String updated;

    public Article() {
    }

    public long getId() {
        return id;
    }

    public Article setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Article setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Article setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public Article setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getUpdated() {
        return updated;
    }

    public Article setUpdated(String updated) {
        this.updated = updated;
        return this;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", category=" + categories +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
