package springCMS.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springCMS.entity.Article;
import springCMS.entity.Category;
import springCMS.repository.ArticleRepository;
import springCMS.repository.AuthorRepository;
import springCMS.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomePageController {
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    public HomePageController(AuthorRepository authorRepository, CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readAll(){
        final String html = articleRepository.findAllArticlesWithCategory1()
                .stream()
                .map(Article::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }
}
