package com.example.map.repository;

import com.example.map.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

    Information findByFeature_Id(Long id);
}
