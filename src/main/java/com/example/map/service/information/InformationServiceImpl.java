package com.example.map.service.information;

import com.example.map.dto.binding.UpdateRouting;
import com.example.map.entity.Information;
import com.example.map.repository.InformationRepository;
import com.example.map.repository.MapRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    private final ModelMapper modelMapper;
    private final MapRepository mapRepository;
    private final InformationRepository informationRepository;

    public InformationServiceImpl(ModelMapper modelMapper, MapRepository mapRepository, InformationRepository informationRepository) {
        this.modelMapper = modelMapper;
        this.mapRepository = mapRepository;
        this.informationRepository = informationRepository;
    }

    @Override
    public void add(Long id, UpdateRouting dto) {
        Information information;
        if (this.informationRepository.findByFeature_Id(id+1) == null) {
            information = this.modelMapper.map(dto, Information.class);
            information.setFeature(mapRepository.findById(id + 1).get());

        } else {
            information = this.informationRepository.findByFeature_Id(id+1);
            information.setBench(dto.getBench())
                    .setBillboard(dto.getBillboard())
                    .setBucket(dto.getBucket())
                    .setLamp(dto.getLamp())
                    .setPeg(dto.getPeg())
                    .setShaft(dto.getShaft())
                    .setSign(dto.getSign())
                    .setStation(dto.getStation())
                    .setTree(dto.getTree());
        }
        this.informationRepository.save(information);

    }

    @Override
    public Information findInformation(Long id) {
        if(this.informationRepository.findByFeature_Id(id)!=null) {
           return this.informationRepository.findByFeature_Id(id);
        }
        return null;
    }
}
