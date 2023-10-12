package com.example.map.repository;

import com.example.map.entity.AlleyCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlleyCriteriaRepository extends JpaRepository<AlleyCriteria, Long> {
    Optional<AlleyCriteria> findByFeature_Id(Long id);
}
