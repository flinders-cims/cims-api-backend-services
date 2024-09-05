package com.flinders.cims.repository;

import com.flinders.cims.model.Research;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchRepository extends JpaRepository<Research, Integer> {
}
