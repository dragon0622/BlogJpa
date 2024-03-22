package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.dto.ArticleResponse;
import com.estsoft.blogjpa.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "blog CRUD")
@RestController
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("api/articles")
    @Operation(summary = "게시글 추가", description = "블로그 메인의 게시글 목록에 추가")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request){
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.toResponse());
    }

    @GetMapping("ari/articles")
    @Operation(summary = "게시글 목록 불러오기", description = "게시글 목록에 모든 게시물 조회")
    @RequestMapping(value="api/allarticles", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleResponse>> showArticle(){
        List<Article> articleList = blogService.findAll();
        List<ArticleResponse> articleResponseList = articleList
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok(articleResponseList);
    }

    @GetMapping("api/articles/{id}")    //id 입력받아서 해당 단건 조회
    public ResponseEntity<ArticleResponse> showOneArticle(@PathVariable Long id){
        Article article = blogService.findById(id);
        return ResponseEntity.ok(article.toResponse());
    }

    @DeleteMapping("api/articles/{id}")
    public ResponseEntity<Void> deleteOneArticle(@PathVariable Long id){
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateOneArticle(@PathVariable Long id,
                                                    @RequestBody AddArticleRequest request){
        Article updatedArticle = blogService.update(id,request);

        return ResponseEntity.status(HttpStatus.OK).body(updatedArticle);
    }
}
