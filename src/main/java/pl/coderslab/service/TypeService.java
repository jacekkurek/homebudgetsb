package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Type;
import pl.coderslab.repository.TypeRepository;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public Type findOne(Long id) {
        return typeRepository.findOne(id);
    }

    public void delete(Long id) {
        typeRepository.delete(id);
    }

    public List<Type> finAll() {
        return typeRepository.findAll();
    }

}
