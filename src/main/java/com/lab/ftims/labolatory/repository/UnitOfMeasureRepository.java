package com.lab.ftims.labolatory.repository;

import com.lab.ftims.labolatory.model.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {

  Optional<UnitOfMeasure> findUnitOfMeasureByDescription(String description);
}
