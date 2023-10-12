package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionAlleyServiceModel;
import com.example.map.entity.AlleyCriteria;
import com.example.map.repository.AlleyCriteriaRepository;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionAlleyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlleyCriteriaServiceImpl implements AlleyCriteriaService {

    private final AlleyCriteriaRepository alleyCriteriaRepository;

    private final QuestionAlleyRepository questionAlleyRepository;

    private final ModelMapper modelMapper;

    private final MapRepository mapRepository;

    public AlleyCriteriaServiceImpl(AlleyCriteriaRepository alleyCriteriaRepository, QuestionAlleyRepository questionAlleyRepository, ModelMapper modelMapper, MapRepository mapRepository) {
        this.alleyCriteriaRepository = alleyCriteriaRepository;
        this.questionAlleyRepository = questionAlleyRepository;
        this.modelMapper = modelMapper;
        this.mapRepository = mapRepository;
    }

    @Override
    public void add(QuestionAlleyServiceModel model, Long id) {
        var accessibilityWalkability = Double.parseDouble(model.getQuestionTwo().split("-")[1]);

        var security = Double.parseDouble(model.getQuestionThree().split("-")[1]);

        var comfortAppeal = Double.parseDouble(model.getQuestionFour().split("-")[1])
                + Double.parseDouble(model.getQuestionFive().split("-")[1])
                + Double.parseDouble(model.getQuestionSix().split("-")[1]);

        AlleyCriteria entity=this.alleyCriteriaRepository.findByFeature_Id(id).orElse(null);

        if(entity==null){
            entity = new AlleyCriteria();
            entity.setAccessibilityWalkability(accessibilityWalkability);
            entity.setSecurity(security);
            entity.setComfortAppeal(comfortAppeal);
            entity.setFeature(this.mapRepository.findById(id).orElse(null));
        }else{
            entity.setAccessibilityWalkability(entity.getAccessibilityWalkability()+accessibilityWalkability);
            entity.setSecurity(entity.getSecurity()+security);
            entity.setComfortAppeal(entity.getComfortAppeal()+comfortAppeal);
        }

        this.alleyCriteriaRepository.save(entity);
    }

    @Override
    public QuestionAlleyCriteriaResultService getResult(Long id) {
        AlleyCriteria entity = this.alleyCriteriaRepository.findByFeature_Id(id).orElse(null);
        QuestionAlleyCriteriaResultService model = new QuestionAlleyCriteriaResultService();
        if(entity!=null){
            var count = this.questionAlleyRepository.countByFeature_Id(id);
            model.setComfortAppeal(((entity.getComfortAppeal()/count)*100)/3.5);
            model.setSecurity((entity.getSecurity()/count)*50);
            model.setAccessibilityWalkability((entity.getAccessibilityWalkability()/count)*50);
        }
       return model;
    }
}
