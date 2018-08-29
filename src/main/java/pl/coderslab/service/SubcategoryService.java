package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Subcategory;
import pl.coderslab.repository.SubcategoryRepository;

import java.util.List;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public Subcategory save (Subcategory subcategory){
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory findOne (Long id){
        return subcategoryRepository.findOne(id);
    }

    public void delete(Long id){
        subcategoryRepository.delete(id);
    }

    public List<Subcategory> findAll(){
        return subcategoryRepository.findAll();
    }
    
}
