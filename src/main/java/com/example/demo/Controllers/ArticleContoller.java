package com.example.demo.Controllers;

import com.example.demo.Models.Article;
import com.example.demo.Serivces.ArticleSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleContoller {
    @Autowired
    private ArticleSerivce articleSerivce;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        List<Article> lst=articleSerivce.ListArticle();
        model.addAttribute("listArticle",lst);

        return  "index";
    }
    @RequestMapping(value = "/deleteArticle/{id}",method= RequestMethod.GET)
    public String deleteArticle(@PathVariable(name="id") int ide)
    {
        articleSerivce.delete(ide);
        return    "redirect:/";
    }
    @RequestMapping(value = "AddArticle",method= RequestMethod.GET)
    public String AddArticle(Model model)
    {
        Article article=new Article();
        model.addAttribute("Article",article);
        return  "AddArticleForm";
    }
    @RequestMapping(value = "saveArticle",method= RequestMethod.POST)
    public String saveArticle(Model model, @ModelAttribute("Article") @Valid Article Article, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "AddArticleForm"; // Return to the form if validation fails
        }

        articleSerivce.saveArticle(Article);
        return    "redirect:/";
    }

    @RequestMapping(value = "/EditArticle/{id}",method=RequestMethod.GET)
    public String EditArticle(@PathVariable(name="id") int id,Model model)
    {
        Article article=articleSerivce.getOne(id);
        model.addAttribute("Article",article);

        return  "EditArticleForm";
    }
    @RequestMapping(value = "/updateArticle/{id}",method=RequestMethod.POST)
    public String updateArticle(@ModelAttribute("Article") Article Article,@PathVariable(name="id") int id,Model model)
    {
        articleSerivce.updateArticle(id,Article);

        return  "redirect:/";
    }
}
