package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.domain.Comment;
import com.estsoft.blogjpa.dto.CommentDTO;
import com.estsoft.blogjpa.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Long articleId, CommentDTO commentDTO){
        Comment comment = commentDTO.toEntity(articleId);
        return commentRepository.save(comment);
    }

    public Comment findCommentById(Long articleId, Long commentId) {

        return commentRepository.findByArticleIdAndId(articleId,commentId).orElseThrow(IllegalAccessError::new);
    }
}
