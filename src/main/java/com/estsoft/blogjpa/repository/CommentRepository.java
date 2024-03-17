package com.estsoft.blogjpa.repository;

import com.estsoft.blogjpa.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByArticleId(Long articleId, Long commentId);
}
