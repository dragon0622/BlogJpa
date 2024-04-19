- BlogJpa 실습 파일
- 아래 항목으로 실습 내용 정리 예정



# 파일 구성

<details>
<summary>Controller</summary>
 
+ BlogController.java 
+ BlogPageController.java
+  CommentController.java
+ FilterTestController.java
+ JsonParseTestController.java
+ PageController.java
+ UserController.java
+ UserViewController.java

</div>
</details>

<details>
<summary>Service</summary>
 
+ BlogService.java
+ CommentService.java
+ UserDetailService.java
+ UserService.java

</div>
</details>

<details>
<summary>Repository</summary>
 
  + BlogRepository.java
  + CommentRepository.java
  + UserRepository.java

</div>
</details>

<details>
<summary>DTO</summary>
 
  + AddArticleRequest.java
  + AddUserRequest.java
  + ArticleResponse.java
  + ArticleViewResponse.java
  + CommentDTO.java
  + CommentResponse.java

</div>
</details>

<details>
<summary>Domain</summary>
 
  + Article.java
  + Comment.java
  + Person.java
  + User.java

</div>
</details>

<details>
<summary>Config</summary>
 
  + FilterConfiguration.java
  + InterceptorConfiguration.java
  + SwaggerConfig.java
  + WebSecurityConfig.java

</div>
</details>

<hr>

# BlogJpa 내용
이스트소프트 부트캠프 오르미 4기 과정 중 Blog CRUD, JPA 활용을 위한 실습 파일이다.

domain, controller, service, repository의 생성 및 내부 메소드 구현, JPA를 통한 database 접근 등을 실습해 보았다.
