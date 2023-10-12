package com.example.map.service.comment;

import com.example.map.dto.response.CommentViewModel;
import com.example.map.dto.service.CommentServiceModel;

import java.util.List;

public interface CommentService {
    CommentViewModel createComment(CommentServiceModel commentServiceModel);
    List<CommentViewModel> getComments(Long routeId);
}
