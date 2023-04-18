package com.demirturk.cmscontentservice.factory;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import com.demirturk.cmscontentservice.entity.Category;
import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscontentservice.entity.article.Article;
import com.demirturk.cmscontentservice.entity.article.MultiPageArticle;
import com.demirturk.cmscontentservice.entity.article.SinglePageArticle;
import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscommons.enums.ArticleType;
import org.springframework.stereotype.Component;

@Component
public class ArticleFactory {
    private ArticleFactory() {
    }

    private static final CommonsModelMapper commonsModelMapper = new CommonsModelMapper();

    public static Article getArticle(ArticleDto articleDto){

        if(articleDto.getArticleType().equals(ArticleType.MULTI_PAGE_ARTICLE)){
            return MultiPageArticle.multiPageBuilder().
                    articleTemplate(commonsModelMapper.map(articleDto.getArticleTemplate(), ArticleTemplate.class)).
                    category(commonsModelMapper.map(articleDto.getCategory(), Category.class)).
                    content(LargeText.builder().text(articleDto.getContent().getText()).build()).
                    description(articleDto.getDescription()).
                    title(articleDto.getTitle()).
                    url(articleDto.getUrl()).
                    keywords(articleDto.getKeywords()).
                    name(articleDto.getName()).
                    build();

        } else if(articleDto.getArticleType().equals(ArticleType.SINGLE_PAGE_ARTICLE)){
            return SinglePageArticle.singlePageArticle().
                    content(LargeText.builder().text(articleDto.getContent().getText()).build()).
                    description(articleDto.getDescription()).
                    title(articleDto.getTitle()).
                    url(articleDto.getUrl()).
                    keywords(articleDto.getKeywords()).
                    name(articleDto.getName()).
                    build();
        }
        return null;

    }
}
