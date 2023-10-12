package com.example.map.repository;

import com.example.map.entity.Specific;
import com.example.map.entity.SpecificType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecificRepository extends JpaRepository<Specific, Long> {
    Optional<Specific> findBySpecific(SpecificType name);
}
