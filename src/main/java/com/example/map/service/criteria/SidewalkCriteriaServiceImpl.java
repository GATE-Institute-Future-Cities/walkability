package com.example.map.service.criteria;

import com.example.map.dto.service.QuestionAlleyCriteriaResultService;
import com.example.map.dto.service.QuestionSidewalkCriteriaResultService;
import com.example.map.dto.service.QuestionSidewalkServiceModel;
import com.example.map.entity.SidewalkCriteria;
import com.example.map.repository.MapRepository;
import com.example.map.repository.QuestionSidewalkRepository;
import com.example.map.repository.SidewalkCriteriaRepository;
import org.springframework.stereotype.Service;

@Service
public class SidewalkCriteriaServiceImpl implements SidewalkCriteriaService {

    private final SidewalkCriteriaRepository sidewalkCriteriaRepository;

    private final QuestionSidewalkRepository questionSidewalkRepository;

    private final MapRepository mapRepository;

    public SidewalkCriteriaServiceImpl(SidewalkCriteriaRepository sidewalkCriteriaRepository, QuestionSidewalkRepository questionSidewalkRepository, MapRepository mapRepository) {
        this.sidewalkCriteriaRepository = sidewalkCriteriaRepository;
        this.questionSidewalkRepository = questionSidewalkRepository;
        this.mapRepository = mapRepository;
    }


    @Override
    public void add(QuestionSidewalkServiceModel model, Long id) {

        var comfortAppeal = Double.parseDouble(model.getQuestionFour().split("-")[2])
                + Double.parseDouble(model.getQuestionFive().split("-")[2])
                + Double.parseDouble(model.getQuestionEight().split("-")[1])
                + Double.parseDouble(model.getQuestionNine().split("-")[1])
                + Double.parseDouble(model.getQuestionTen().split("-")[1])
                + Double.parseDouble(model.getQuestionEleven().split("-")[1])
                + Double.parseDouble(model.getQuestionTwelve().split("-")[1]);


        var accessibilityWalkability = Double.parseDouble(model.getQuestionOne().split("-")[1])
                + Double.parseDouble(model.getQuestionTwo().split("-")[1])
                + Double.parseDouble(model.getQuestionThree().split("-")[1]);

        var security = Double.parseDouble(model.getQuestionFour().split("-")[1])
                + Double.parseDouble(model.getQuestionFive().split("-")[1])
                + Double.parseDouble(model.getQuestionSix().split("-")[1])
                + Double.parseDouble(model.getQuestionSeven().split("-")[1]);

        SidewalkCriteria entity = this.sidewalkCriteriaRepository.findByFeature_Id(id).orElse(null);

        if (entity == null) {
            entity = new SidewalkCriteria();
            entity.setAccessibilityWalkability(accessibilityWalkability);
            entity.setSecurity(security);
            entity.setComfortAppeal(comfortAppeal);
            entity.setFeature(this.mapRepository.findById(id).orElse(null));
        } else {
            entity.setAccessibilityWalkability(entity.getAccessibilityWalkability() + accessibilityWalkability);
            entity.setSecurity(entity.getSecurity() + security);
            entity.setComfortAppeal(entity.getComfortAppeal() + comfortAppeal);
        }

        this.sidewalkCriteriaRepository.save(entity);
    }

    @Override
    public QuestionSidewalkCriteriaResultService getResult(Long id) {
        SidewalkCriteria entity = this.sidewalkCriteriaRepository.findByFeature_Id(id).orElse(null);
        QuestionSidewalkCriteriaResultService model = new QuestionSidewalkCriteriaResultService();
        if (entity != null) {
            var count = this.questionSidewalkRepository.countByFeature_Id(id);
            model.setComfortAppeal(((entity.getComfortAppeal() / count) * 100) / 6);
            model.setSecurity(((entity.getSecurity() / count) * 100) / 4);
            model.setAccessibilityWalkability(((entity.getAccessibilityWalkability() / count) * 100) / 5);
        }
        return model;
    }
}
