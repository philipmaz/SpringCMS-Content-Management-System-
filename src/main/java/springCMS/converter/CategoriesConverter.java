package springCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import springCMS.entity.Category;
import springCMS.repository.CategoryRepository;

import java.util.Optional;

public class CategoriesConverter implements Converter<String, Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String id) { return categoryRepository.findById(Long.parseLong(id)); }
}
