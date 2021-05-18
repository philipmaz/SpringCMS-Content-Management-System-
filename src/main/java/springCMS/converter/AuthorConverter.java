package springCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import springCMS.entity.Author;
import springCMS.repository.AuthorRepository;

import java.util.Optional;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author convert(String id) {
        return authorRepository.findById(Long.parseLong(id));
    }
}
