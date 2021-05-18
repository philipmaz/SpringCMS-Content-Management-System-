package springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springCMS.entity.Article;
import springCMS.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    Author findById(long id);
}
