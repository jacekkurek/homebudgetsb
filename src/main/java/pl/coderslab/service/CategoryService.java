package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category save (Category category){
        return categoryRepository.save(category);
    }

    public Category findOne (Long id){
        return categoryRepository.findOne(id);
    }

    public void delete(Long id){
        categoryRepository.delete(id);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

}
