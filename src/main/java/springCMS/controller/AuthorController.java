package springCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springCMS.entity.Author;
import springCMS.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/readall")
    @ResponseBody
    public String readall(){
        final String html = authorRepository.findAll()
                .stream()
                .map(Author::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/addauthor")
    public String addAuthorForm(Model m){
        m.addAttribute("author", new Author());
        return "author/authorform";
    }

    @PostMapping("/addauthor")
    public String addAuthorForm(@ModelAttribute @Valid Author author, BindingResult violations){
        if(violations.hasErrors()){
            return "author/authorform";
        }
        authorRepository.save(author);
        return "redirect:readall";
    }

    @GetMapping("/{id}/edit")
    public String editAuthor(Model m, @PathVariable long id){
        m.addAttribute("author", authorRepository.findById(id));
        return "author/authorform";
    }

    @PostMapping("/{id}/edit")
    public String editAuthor(@ModelAttribute @Valid Author author, BindingResult violations){
        if(violations.hasErrors()){
            return "author/authorform";
        }
        authorRepository.save(author);
        return "redirect:../readall";
    }

    @GetMapping("/{id}/delete")
    public String deleteAuthor(Model m, @PathVariable long id){
        m.addAttribute("author", authorRepository.findById(id));
        return "author/authorform";
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@ModelAttribute Author author){

        authorRepository.delete(author);
        return "redirect:../readall";
    }
}
