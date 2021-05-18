package springCMS.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springCMS.entity.Article;
import springCMS.entity.Author;
import springCMS.entity.Category;
import springCMS.repository.ArticleRepository;
import springCMS.repository.AuthorRepository;
import springCMS.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @PersistenceContext
    private EntityManager em;
    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    public ArticleController(ArticleRepository articleRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
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

    @GetMapping("/all")
    public String showArticles(Model model) {
        List<Article> articles = articleRepository.findAllArticlesWithCategory1();
        model.addAttribute("articles", articles);
        return "article/allarticles";
    }

    @GetMapping("/addarticle")
    public String addArticleForm(Model m){
        m.addAttribute("article", new Article());
        return "article/articleform";
    }

    @PostMapping("/addarticle")
    public String addArticleForm(@ModelAttribute @Valid Article article, BindingResult violations){
        if(violations.hasErrors()){
            return "article/articleform";
        }
        articleRepository.save(article);
        return "redirect:all";
    }

    @GetMapping("/{id}/edit")
    public String editArticle(Model m, @PathVariable long id){

        Query q = em.createQuery("SELECT e FROM Article e LEFT JOIN FETCH e.categories WHERE e.id=:id");            // musialem użyć entity managera bo nie znajdowalo sesji id
        q.setParameter("id",id);                                                                                    // tym sposobem formularz wyswietla od razu zaznaczone kategorie

        m.addAttribute("article", (Article) q.getResultList().get(0));
        return "article/articleform";
    }

    @PostMapping("/{id}/edit")
    public String editArticle(@ModelAttribute @Valid Article article, BindingResult violations){
        if(violations.hasErrors()){
            return "article/articleform";
        }
        articleRepository.save(article);
        return "redirect:../all";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(Model m, @PathVariable long id){

        Query q = em.createQuery("SELECT e FROM Article e LEFT JOIN FETCH e.categories WHERE e.id=:id");
        q.setParameter("id",id);

        m.addAttribute("article", (Article) q.getResultList().get(0));
        return "article/articleform";
    }

    @PostMapping("/{id}/delete")
    public String deleteArticle(@ModelAttribute Article article){

        articleRepository.delete(article);
        return "redirect:../all";
    }


    @GetMapping("/{id}/articlesbycat")
    @Transactional
    public String showArticlesByCat(@PathVariable long id, Model m){

        List<Article> articles= articleRepository.findByCategoriesId(id);                   //Spring Data JPa knows it should search by categories id not articles id from the method nomenclature

        for(Article a : articles){
            Hibernate.initialize(a.getCategories());
        }

        m.addAttribute("articles", articles);

        return "article/allarticles";
    }



    @ModelAttribute("categories")
    public List<Category> categories(){return  categoryRepository.findAll();}

    @ModelAttribute("authors")
    public List<Author> authors() { return authorRepository.findAll(); }




}
