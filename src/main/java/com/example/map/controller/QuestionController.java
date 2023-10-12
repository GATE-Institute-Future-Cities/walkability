package com.example.map.controller;

import com.example.map.dto.request.QuestionAlleyRequest;
import com.example.map.dto.request.QuestionSidewalkRequest;
import com.example.map.dto.response.*;
import com.example.map.dto.service.QuestionAlleyServiceModel;
import com.example.map.dto.service.QuestionCrossingServiceModel;
import com.example.map.dto.service.QuestionSidewalkServiceModel;
import com.example.map.service.criteria.AlleyCriteriaService;
import com.example.map.service.criteria.CrossingCriteriaService;
import com.example.map.service.criteria.SidewalkCriteriaService;
import com.example.map.service.question.QuestionAllayService;
import com.example.map.dto.request.QuestionCrossingRequest;
import com.example.map.service.question.QuestionCrossingService;
import com.example.map.service.question.QuestionSidewalkService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionAllayService questionAllayService;
    private final QuestionCrossingService questionCrossingService;
    private final QuestionSidewalkService questionSidewalkService;
    private final AlleyCriteriaService alleyCriteriaService;
    private final CrossingCriteriaService crossingCriteriaService;
    private final SidewalkCriteriaService sidewalkCriteriaService;
    private final ModelMapper modelMapper;

    public QuestionController(QuestionAllayService questionAllayService, QuestionCrossingService questionCrossingService, QuestionSidewalkService questionSidewalkService, AlleyCriteriaService alleyCriteriaService, CrossingCriteriaService crossingCriteriaService, SidewalkCriteriaService sidewalkCriteriaService, ModelMapper modelMapper) {
        this.questionAllayService = questionAllayService;
        this.questionCrossingService = questionCrossingService;
        this.questionSidewalkService = questionSidewalkService;
        this.alleyCriteriaService = alleyCriteriaService;
        this.crossingCriteriaService = crossingCriteriaService;
        this.sidewalkCriteriaService = sidewalkCriteriaService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/sidewalk/{id}")
    public String getQuestionsSidewalk(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "questionsSidewalk";
    }

    @GetMapping("/alley/{id}")
    public String getQuestionsAllay(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "questionsAlley";
    }

    @GetMapping("/crossing/{id}")
    public String getQuestionsCrossing(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "questionsCrossing";
    }

    @PostMapping("/alley/{id}")
    public String postQuestionsAllay(@PathVariable Long id, @Valid @ModelAttribute("questionsAlleyRequest") QuestionAlleyRequest questionAlleyRequest) {
        this.questionAllayService.add(this.modelMapper.map(questionAlleyRequest, QuestionAlleyServiceModel.class), id);
        this.alleyCriteriaService.add(this.modelMapper.map(questionAlleyRequest, QuestionAlleyServiceModel.class), id);

        return "redirect:/";
    }

    @PostMapping("/crossing/{id}")
    public String postQuestionsCrossing(@PathVariable Long id, @Valid @ModelAttribute("questionsCrossingRequest") QuestionCrossingRequest questionCrossingRequest) {
        this.questionCrossingService.add(this.modelMapper.map(questionCrossingRequest, QuestionCrossingServiceModel.class), id);
        this.crossingCriteriaService.add(this.modelMapper.map(questionCrossingRequest, QuestionCrossingServiceModel.class), id);

        return "redirect:/";
    }

    @PostMapping("/sidewalk/{id}")
    public String postQuestionsSidewalk(@PathVariable Long id, @Valid @ModelAttribute("questionsSidewalkRequest") QuestionSidewalkRequest questionSidewalkRequest) {
        this.questionSidewalkService.add(this.modelMapper.map(questionSidewalkRequest, QuestionSidewalkServiceModel.class), id);
        this.sidewalkCriteriaService.add(this.modelMapper.map(questionSidewalkRequest, QuestionSidewalkServiceModel.class), id);

        return "redirect:/";
    }

    @GetMapping("/alley/result/{id}")
    public String getQuestionsAllayResult(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.questionAllayService.getResult(id), QuestionAlleyResultResponse.class));
        return "questionsAlleyResult";
    }

    @GetMapping("/crossing/result/{id}")
    public String getQuestionsCrossingResult(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.questionCrossingService.getResult(id), QuestionCrossingResultResponse.class));
        return "questionsCrossingResult";
    }

    @GetMapping("/sidewalk/result/{id}")
    public String getQuestionsSidewalkResult(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.questionSidewalkService.getResult(id), QuestionSidewalkResultResponse.class));
        return "questionsSidewalkResult";
    }

    @GetMapping("/alley/result/criteria/{id}")
    public String getQuestionsAllayResultCriteria(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.alleyCriteriaService.getResult(id), QuestionAlleyCriteriaResultResponse.class));

        return "questionsAlleyCriteriaResult";
    }

    @GetMapping("/crossing/result/criteria/{id}")
    public String getQuestionsCrossingResultCriteria(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.crossingCriteriaService.getResult(id), QuestionCrossingCriteriaResultResponse.class));

        return "questionsCrossingCriteriaResult";
    }

    @GetMapping("/sidewalk/result/criteria/{id}")
    public String getQuestionsSidewalkResultCriteria(@PathVariable Long id, Model model) {
        model.addAttribute("result", modelMapper.map(this.sidewalkCriteriaService.getResult(id), QuestionSidewalkCriteriaResultResponse.class));

        return "questionsSidewalkCriteriaResult";
    }
}
