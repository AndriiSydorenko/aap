package com.dip.aap.controller;

import com.dip.aap.dao.ArticleDAO;
import com.dip.aap.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by andrz on 6/25/2017.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleDAO articleDao;

    List<Article> articlesLocal;
    int rowsNumShort = 3;
    int rowsNumLong = 15;

    public List<Article> findAll() {
        return articleDao.findAll();
    }

    public List<Article> findAllJava() {
        return articleDao.findAllJava();
    }

    //Common

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String getAllArticles(Model model) {
        if (articlesLocal == null) {
            articlesLocal = findAll();
        }
        model.addAttribute("articles", articlesLocal);
        model.addAttribute("message", "Articles:");
        return "articlesListView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/java")
    public String getAllJavaArticles(Model model) {
        model.addAttribute("articles", findAllJava());
        return "articlesListView";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public String getAddAtricle() {
        return "addArticle";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String editArticle(@PathVariable("id") int articleId, Model model) {
        Article editedArticle = articleDao.findById(articleId);
        model.addAttribute("article", editedArticle);
        return "editArticle";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String deleteArticle(@PathVariable("id") int articleId) {
        articleDao.DeleteArticle(articleId);
        articlesLocal = findAll();
        return "redirect:/articles/all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new/add")
    public String AddNewArticle(@RequestParam String name_text,
                                @RequestParam String content_text,
                                @RequestParam String category_text,
                                Model model) {
        Article article = new Article();
        article.setName(name_text);
        article.setContent(content_text);
        article.setCategory(category_text);
        articleDao.persist(article);
        articlesLocal = findAll();
        return "redirect:/articles/all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}/save")
    public String SaveArticle(@PathVariable("articleId") int articleId,
                              @RequestParam String name_text,
                              @RequestParam String content_text,
                              @RequestParam String category_text,
                              Model model) {
        Article article = articleDao.findById(articleId);
        article.setName(name_text);
        article.setContent(content_text);
        article.setCategory(category_text);
        articleDao.merge(article);
        articlesLocal = findAll();
        return "redirect:/articles/all";
    }
}
