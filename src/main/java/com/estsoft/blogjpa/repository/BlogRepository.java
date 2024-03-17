package com.estsoft.blogjpa.repository;

import com.estsoft.blogjpa.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    //상속을 받으면서 이 레파지토리를 사용할땓, JpaRepository에서 제공하는 여러 메소드 사용 가능
}
