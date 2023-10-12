package com.example.map.controller;

import com.example.map.dto.binding.NewCommentBindingModel;
import com.example.map.dto.response.CommentViewModel;
import com.example.map.dto.service.CommentServiceModel;
import com.example.map.service.comment.CommentService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentController(CommentService commentService,
                                 ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{routeId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(
            @PathVariable Long routeId,
            Principal principal
    ) {
        return ResponseEntity.ok(
                commentService.getComments(routeId));
    }

    @PostMapping("/api/{routeId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @PathVariable Long routeId,
            @RequestBody @Valid NewCommentBindingModel newCommentBindingModel,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        CommentServiceModel serviceModel =
                modelMapper.map(newCommentBindingModel, CommentServiceModel.class);
        serviceModel.setCreator(userDetails.getUsername());
        serviceModel.setRouteId(routeId);

        CommentViewModel newComment =
                commentService.createComment(serviceModel);

        URI locationOfNewComment =
                URI.create(String.format("/api/%s/comments/%s", routeId, newComment.getCommentId()));

        return ResponseEntity.
                created(locationOfNewComment).
                body(newComment);
    }
}
