package com.example.map.repository;

import com.example.map.entity.SidewalkCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SidewalkCriteriaRepository extends JpaRepository<SidewalkCriteria, Long> {
    Optional<SidewalkCriteria> findByFeature_Id(Long id);
}
