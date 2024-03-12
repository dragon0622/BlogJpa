package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.dto.ArticleResponse;
import com.estsoft.blogjpa.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("api/articles")
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request){
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.toResponse());
    }

    //=@GetMapping("ari/articles")
    @RequestMapping(value="api/allarticles", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleResponse>> showArticle(){
        List<Article> articleList = blogService.findAll();
        List<ArticleResponse> articleResponseList = articleList
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok(articleResponseList);
    }

    @GetMapping("api/articles/{id}")
    public ResponseEntity<ArticleResponse> showOneArticle(@RequestParam(String title)){
    }
}
