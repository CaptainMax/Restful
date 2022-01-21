package com.example.Restful.controller;

import com.example.Restful.AjaxResponse;
import com.example.Restful.model.Article;
import com.example.Restful.model.Reader;
import com.example.Restful.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

    //search an article by id
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){

//        List<Reader> readers = new ArrayList<Reader>(){{
//            add(new Reader("kobe", 21));
//            add(new Reader("james", 20));
//        }};
//
//        Article article = Article.builder()
//                .id(id)
//                .author("Max")
//                .content("Spring course")
//                .createTime(new Date())
//                .reader(readers)
//                .title("t1")
//                .build();
        Article article = articleService.getArticle(id);

        log.info("article:" + article);

        return AjaxResponse.success(article);
    }
    /**
     * @RequestBody can take all object
     */
    //create an article
    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse pustArticle(@RequestBody Article article){

        articleService.saveArticle(article);

        log.info("SaveArticle:" + article);

        return AjaxResponse.success();
    }

//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
//    @PostMapping("/articles")
//    //requestParam can only take one by one
//    public AjaxResponse getArticle(@RequestParam String author,
//                                   @RequestParam String title,
//                                   @RequestParam String content,
//                                   //time cast from string to date
//                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                   @RequestParam Date createTime
//                                   ){
//        log.info("SaveArticle:" + createTime);
//
//        return AjaxResponse.success();
//    }



    //edit an article
    //@RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
//        if(article.getId() == null){
//
//        }
        articleService.updateArticle(article);
        log.info("updateArticle:" + article);

        return AjaxResponse.success();
    }

    //delete an article
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){

        articleService.deleteArticle(id);

        log.info("updateArticle:" + id);

        return AjaxResponse.success();
    }

    @GetMapping("/articlesgetall")
    public AjaxResponse getArticle(){


       List<Article> articles = articleService.getAll();

        log.info("article:" + articles);

        return AjaxResponse.success(articles);
    }
}
