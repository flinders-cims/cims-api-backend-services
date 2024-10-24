package com.flinders.cims.repository;

import com.flinders.cims.model.Research;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchRepository extends JpaRepository<Research, Integer> {
    List<Research> findByUser_UserId(int userId);
    Research findByTitle(String title);
}
