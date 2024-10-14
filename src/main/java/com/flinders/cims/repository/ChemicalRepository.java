package com.flinders.cims.repository;

import com.flinders.cims.model.Chemical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical, Integer> {
    Optional<Chemical> findBySystematicName(String systematicName);
}
