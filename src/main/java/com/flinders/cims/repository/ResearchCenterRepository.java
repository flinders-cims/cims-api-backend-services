package com.flinders.cims.repository;

import com.flinders.cims.model.ResearchCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchCenterRepository extends JpaRepository<ResearchCenter, Integer> {
}
