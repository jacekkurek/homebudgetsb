package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.repository.SubcategoryRepository;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }
}
