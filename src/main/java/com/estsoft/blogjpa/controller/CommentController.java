package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Comment;
import com.estsoft.blogjpa.dto.CommentDTO;
import com.estsoft.blogjpa.dto.CommentResponse;
import com.estsoft.blogjpa.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments/{articleId}")
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long articleId, @RequestBody CommentDTO commentDTO){
        Comment comment = commentService.createComment(articleId,commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment.toResponse());
    }

    @GetMapping("/comments/{articleId}/{commentId}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long articleId,
                                                      @PathVariable Long commentId){
        Comment comment = commentService.findCommentById(articleId, commentId);

        return ResponseEntity.ok(comment.toResponse());
    }

}
