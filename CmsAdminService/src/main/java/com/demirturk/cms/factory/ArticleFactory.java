package com.demirturk.cms.factory;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.Category;
import com.demirturk.cms.entity.article.Article;
import com.demirturk.cms.entity.article.MultiPageArticle;
import com.demirturk.cms.entity.article.SinglePageArticle;
import com.demirturk.cms.enums.ArticleType;
import com.demirturk.cms.model.dto.ArticleDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleFactory {
    private ArticleFactory() {
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Article getArticle(ArticleDto articleDto){

        if(articleDto.getArticleType().equals(ArticleType.MULTI_PAGE_ARTICLE)){
            return MultiPageArticle.multiPageBuilder().
                    articleTemplate(modelMapper.map(articleDto.getArticleTemplate(), ArticleTemplate.class)).
                    category(modelMapper.map(articleDto.getCategory(), Category.class)).
                    content(articleDto.getContent()).
                    description(articleDto.getDescription()).
                    title(articleDto.getTitle()).
                    url(articleDto.getUrl()).
                    keywords(articleDto.getKeywords()).
                    name(articleDto.getName()).
                    build();

        } else if(articleDto.getArticleType().equals(ArticleType.SINGLE_PAGE_ARTICLE)){
            return SinglePageArticle.singlePageArticle().
                    content(articleDto.getContent()).
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
