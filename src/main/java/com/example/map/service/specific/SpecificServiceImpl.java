package com.example.map.service.specific;

import com.example.map.entity.Specific;
import com.example.map.repository.SpecificRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecificServiceImpl implements SpecificService {

    private final SpecificRepository specificRepository;

    public SpecificServiceImpl(SpecificRepository specificRepository) {
        this.specificRepository = specificRepository;
    }

    @Override
    public Specific findSpecificById(Long id) {
        return specificRepository.findById(id).orElse(null);
    }
}
