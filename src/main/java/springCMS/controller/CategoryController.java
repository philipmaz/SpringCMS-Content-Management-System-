package springCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springCMS.entity.Article;
import springCMS.entity.Category;
import springCMS.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cat")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readAll(){
        final String html = categoryRepository.findAll()
                .stream()
                .map(Category::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/all")
    public String showCategories(Model m){
        List<Category> categories = categoryRepository.findAll();
        m.addAttribute("categories",categories);
        return "category/allcategories";
    }

    @GetMapping("/addcat")
    public String addCat(Model m){
        m.addAttribute("category", new Category());
        return "category/categoryform";
    }

    @PostMapping("/addcat")
    public String addCat(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:all";
    }

    @GetMapping("/editcat/{id}")
    public String editCat(@PathVariable long id, Model m){
        m.addAttribute("category", categoryRepository.findById(id));
        return "category/categoryform";
    }

    @PostMapping("/editcat/{id}")
    public String editCat(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:../all";
    }

    @GetMapping("/deletecat/{id}")
    public String deleteCat(@PathVariable long id, Model m){
        m.addAttribute("category", categoryRepository.findById(id));
        return "category/categoryform";
    }

    @PostMapping("/deletecat/{id}")
    public String deleteCat(@ModelAttribute Category category){
        categoryRepository.delete(category);
        return "redirect:../all";
    }

    @GetMapping("/{id}/change")
    public String changeActive(@PathVariable long id){
        Category category = categoryRepository.findById(id);
        category.setIsActive(!category.getIsActive());                  // set the opposite bool value than it is now
        categoryRepository.save(category);

        return "redirect:../all";
    }







}
