package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private String body;

    public Comment toEntity(Long id){
        return Comment.builder()
                .articleId(id)
                .body(this.body)
                .build();
    }
}
