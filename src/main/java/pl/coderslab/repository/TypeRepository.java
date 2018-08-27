package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
