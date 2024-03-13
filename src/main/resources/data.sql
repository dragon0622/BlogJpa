-- create table article not exists article (
--                          id BIGINT AUTO_INCREMENT primary key,
--                          title varchar(255) not null,
--                          content varchar(255) not null
-- );

INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목', '블로그 내용', NOW(), NOW()); --최초 생성시에도 생성시간, 수정시간을 수정할 수 있도록 sql 수정
INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목2', '블로그 내용2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목3', '블로그 내용3', NOW(), NOW());