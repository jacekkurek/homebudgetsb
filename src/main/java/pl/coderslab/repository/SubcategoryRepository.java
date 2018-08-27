package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Subcategory;


@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {




}
