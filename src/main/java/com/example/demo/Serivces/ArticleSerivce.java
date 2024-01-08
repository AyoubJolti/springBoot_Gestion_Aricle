package com.example.demo.Serivces;

import com.example.demo.Models.Article;
import com.example.demo.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleSerivce {

    @Autowired
    private ArticleRepository articleRepository;
    public List<Article> ListArticle()
    {
        return  this.articleRepository.findAll();
    }
    public void saveArticle(Article ar)
    {
        articleRepository.save(ar);
    }
    public void delete(int id){
        this.articleRepository.deleteById(id);
    }
    public  Article getOne(int id){
        return this.articleRepository.findById(id).get();
    }
    public void updateArticle(int id,Article ar){
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            Article articleToUpdate = articleOptional.get();

            // Keep the existing category value

            // Update other properties
            articleToUpdate.setNom_Art(ar.getNom_Art());
            articleToUpdate.setQte(ar.getQte());
            articleToUpdate.setPrix(ar.getPrix());

            // Save the updated article
            articleRepository.save(articleToUpdate);
        }

        articleRepository.save(ar);

    }
}

