package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.domain.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private String body;
    private LocalDateTime created_at;

    public CommentResponse(Comment comment) {
        id = comment.getId();
        body = comment.getBody();
        created_at = comment.getCreatedAt();
    }
}
