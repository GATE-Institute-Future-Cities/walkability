package com.example.map.service.comment;

import com.example.map.dto.response.CommentViewModel;
import com.example.map.dto.service.CommentServiceModel;
import com.example.map.entity.CommentEntity;
import com.example.map.repository.CommentRepository;
import com.example.map.repository.MapRepository;
import com.example.map.repository.UserRepository;
import com.example.map.service.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final MapRepository mapRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(MapRepository mapRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.mapRepository = mapRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) {
        Objects.requireNonNull(commentServiceModel.getCreator());

        var route = mapRepository.
                findById(commentServiceModel.getRouteId()).
                orElseThrow(() -> new ObjectNotFoundException("Route with id " + commentServiceModel.getRouteId() + " not found!"));

        var author = userRepository.
                findByUsername(commentServiceModel.getCreator()).
                orElseThrow(() -> new ObjectNotFoundException("User with eamil " + commentServiceModel.getCreator() + " not found!"));

        CommentEntity newComment = new CommentEntity();
        newComment.setApproved(false);
        newComment.setTextContent(commentServiceModel.getMessage());
        newComment.setCreated(LocalDateTime.now());
        newComment.setFeature(route);
        newComment.setUser(author);

        CommentEntity savedComment = commentRepository.save(newComment);

        return mapAsComment(savedComment);
    }

    @Transactional
    @Override
    public List<CommentViewModel> getComments(Long routeId) {
        routeId++;
        var routeOpt = mapRepository.
                findById(routeId);

        if (routeOpt.isEmpty()) {
            throw new ObjectNotFoundException("Route with id " + routeId + " was not found!");
        }

        return routeOpt.
                get().
                getComments().
                stream().
                map(this::mapAsComment).
                collect(Collectors.toList());
    }

    private CommentViewModel mapAsComment(CommentEntity commentEntity) {
        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel.
                setCommentId(commentEntity.getId()).
                setCanApprove(true).
                setCanDelete(true).
                setCreated(commentEntity.getCreated()).
                setMessage(commentEntity.getTextContent()).
                setUser(commentEntity.getUser().getUsername());

        return commentViewModel;
    }
}
