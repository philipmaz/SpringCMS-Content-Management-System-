package springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springCMS.entity.Article;
import springCMS.entity.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT DISTINCT e FROM Article e LEFT JOIN FETCH e.categories")
    List<Article> findAllArticlesWithCategory1();

    @Query("SELECT DISTINCT e FROM Article e LEFT JOIN FETCH e.categories ORDER BY e.created")
    List<Article> findAllArticlesWithCategoryOrderByCreated();

    @Query(value = "SELECT * FROM articles a LEFT JOIN FETCH articles_categories ac ON a.id=ac.article_id LEFT JOIN categories c ON ac.categories_id=c.id", nativeQuery = true)
    List<Article> findAllArticlesWithCategoryLimit5();

    List<Article> findByCategoriesId(long id);


}
