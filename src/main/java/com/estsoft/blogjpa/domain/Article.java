package com.estsoft.blogjpa.domain;

import com.estsoft.blogjpa.dto.ArticleResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //엔티티의 변화를 감지하겠다.
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleResponse toResponse(){
        return ArticleResponse.builder()
                .title(title)
                .content(content)
                .build();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    @CreatedDate    //엔티티가 생성될때 생성 시간을 테이블의 created_at 컬럼에 저장하겠다.
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate   //마지막으로 수정될때 updated_at에 시간을 저장하겠다.
    @Column(name = "updated_at")
    private LocalDateTime updateAt;
}