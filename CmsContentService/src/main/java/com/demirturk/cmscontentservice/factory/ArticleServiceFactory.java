package com.demirturk.cmscontentservice.factory;

import com.demirturk.cmscontentservice.service.ArticleService;
import com.demirturk.cmscommons.enums.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ArticleServiceFactory {
    private ArticleServiceFactory() {
    }

    @Autowired @Qualifier("singlePageArticleService")
    private ArticleService singlePageArticleService;

    @Autowired @Qualifier("multiPageArticleService")
    private ArticleService multiPageArticleService;

    @Autowired @Qualifier("articleService")
    private ArticleService articleService;

    public ArticleService getArticleService(String type){

        if (ArticleType.Values.MULTI_PAGE_ARTICLE.equals(type)){
            return multiPageArticleService;
        } else if (ArticleType.Values.SINGLE_PAGE_ARTICLE.equals(type)){
            return singlePageArticleService;
        } else if (ArticleType.Values.ARTICLE.equals(type)){
            return articleService;
        }
        return null;
    }
}
