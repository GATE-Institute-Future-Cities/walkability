package com.example.map.service.information;

import com.example.map.dto.binding.UpdateRouting;
import com.example.map.entity.Information;

public interface InformationService {
    void add(Long id, UpdateRouting dto);

    Information findInformation(Long id);
}
