package com.estsoft.blogjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "article_id", updatable = false)
    private Long articleId;

    @Column(name = "body", updatable = false)
    private String body;

    @CreatedDate    //엔티티가 생성될때 생성 시간을 테이블의 created_at 컬럼에 저장하겠다.
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Comment(Long articleId, String body){
        this.articleId = articleId;
        this.body = body;
    }

}
