package com.estsoft.blogjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //JPA Auditing 기능 활성화 ( 엔티티 변경 이력 추적, 생성일자 및 수정일자 자동 설정)
@SpringBootApplication
public class BlogJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogJpaApplication.class, args);
    }

}
