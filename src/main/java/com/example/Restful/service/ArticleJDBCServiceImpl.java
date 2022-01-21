package com.example.Restful.service;

import com.example.Restful.dao.ArticleJDBCDAO;

import com.example.Restful.model.Article;

//import com.example.Restful.model.ArticleVO;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.nio.MappedByteBuffer;
import java.util.List;
@Service
public class ArticleJDBCServiceImpl implements ArticleService{

    //jdbc inject
    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if(article.getId() == null) {

        }
        //articleJDBCDAO.updateById(article);
        articleJDBCDAO.deleteById(article.getId());
        articleJDBCDAO.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
