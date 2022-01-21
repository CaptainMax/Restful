package com.example.Restful.service;

import com.example.Restful.model.Article;
import org.springframework.stereotype.Service;
//import com.example.Restful.model.ArticleVO;

import java.util.List;
@Service
public interface ArticleService {
    public void saveArticle(Article article);
    void deleteArticle(Long id);
    void updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();
}
