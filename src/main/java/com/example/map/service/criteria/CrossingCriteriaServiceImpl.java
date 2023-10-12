package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionCrossingCriteriaResultService;
import com.example.map.dto.service.QuestionCrossingServiceModel;
import com.example.map.entity.AlleyCriteria;
import com.example.map.entity.CrossingCriteria;
import com.example.map.repository.CrossingCriteriaRepository;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionCrossingRepository;
import org.springframework.stereotype.Service;

@Service
public class CrossingCriteriaServiceImpl implements CrossingCriteriaService {

    private final CrossingCriteriaRepository crossingCriteriaRepository;

    private final QuestionCrossingRepository questionCrossingRepository;

    private final MapRepository mapRepository;

    public CrossingCriteriaServiceImpl(CrossingCriteriaRepository crossingCriteriaRepository, QuestionCrossingRepository questionCrossingRepository, MapRepository mapRepository) {
        this.crossingCriteriaRepository = crossingCriteriaRepository;
        this.questionCrossingRepository = questionCrossingRepository;
        this.mapRepository = mapRepository;
    }

    @Override
    public void add(QuestionCrossingServiceModel model, Long id) {
        var accessibilityWalkability = Double.parseDouble(model.getQuestionTwo().split("-")[1])
                + Double.parseDouble(model.getQuestionThree().split("-")[1])
                + Double.parseDouble(model.getQuestionFour().split("-")[1]);

        var security = Double.parseDouble(model.getQuestionOne().split("-")[1])
                + Double.parseDouble(model.getQuestionTwo().split("-")[2])
                + Double.parseDouble(model.getQuestionFour().split("-")[2])
                + Double.parseDouble(model.getQuestionFive().split("-")[1]);

        CrossingCriteria entity=this.crossingCriteriaRepository.findByFeature_Id(id).orElse(null);

        if(entity==null){
            entity = new CrossingCriteria();
            entity.setAccessibilityWalkability(accessibilityWalkability);
            entity.setSecurity(security);
            entity.setFeature(this.mapRepository.findById(id).orElse(null));
        }else{
            entity.setAccessibilityWalkability(entity.getAccessibilityWalkability()+accessibilityWalkability);
            entity.setSecurity(entity.getSecurity()+security);
        }

        this.crossingCriteriaRepository.save(entity);
    }

    @Override
    public QuestionCrossingCriteriaResultService getResult(Long id) {
        CrossingCriteria entity = this.crossingCriteriaRepository.findByFeature_Id(id).orElse(null);
        QuestionCrossingCriteriaResultService model = new QuestionCrossingCriteriaResultService();
        if(entity!=null) {
            var count = this.questionCrossingRepository.countByFeature_Id(id);
            model.setSecurity(((entity.getSecurity() / count) * 100) / 6);
            model.setAccessibilityWalkability(((entity.getAccessibilityWalkability() / count) * 100) / 5);
        }
        return model;
    }
}
