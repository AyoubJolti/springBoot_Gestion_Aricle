package com.example.demo.Repositories;

import com.example.demo.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article,Integer> {

}
