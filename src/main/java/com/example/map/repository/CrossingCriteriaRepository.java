package com.example.map.repository;

import com.example.map.entity.CrossingCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrossingCriteriaRepository extends JpaRepository<CrossingCriteria, Long> {

    Optional<CrossingCriteria> findByFeature_Id(Long id);
}
