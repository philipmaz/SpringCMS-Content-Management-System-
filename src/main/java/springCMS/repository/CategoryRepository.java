package springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springCMS.entity.Article;
import springCMS.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long id);
}
