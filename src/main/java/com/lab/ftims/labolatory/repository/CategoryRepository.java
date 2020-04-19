package com.lab.ftims.labolatory.repository;

import com.lab.ftims.labolatory.model.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findCategoryByDescription(String description);
}
