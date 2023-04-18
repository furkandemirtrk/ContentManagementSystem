package com.demirturk.cmscontentservice.util;

import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import com.demirturk.cmscontentservice.entity.Category;
import com.demirturk.cmscontentservice.entity.CategoryTemplate;
import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscontentservice.entity.article.MultiPageArticle;
import com.demirturk.cmscontentservice.entity.article.SinglePageArticle;
import com.demirturk.cmscontentservice.repository.ArticleRepository;
import com.demirturk.cmscontentservice.repository.ArticleTemplateRepository;
import com.demirturk.cmscontentservice.repository.CategoryRepository;
import com.demirturk.cmscontentservice.repository.CategoryTemplateRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DBInitializerUtil {
    private final CategoryTemplateRepository categoryTemplateRepository;
    private final CategoryRepository categoryRepository;
    private final ArticleTemplateRepository articleTemplateRepository;
    private final ArticleRepository articleRepository;

    @PostConstruct
    private void initDb(){
        if (categoryTemplateRepository.count() < 1){
            createCategoryTemplate();
        }
    }

    private void createCategoryTemplate(){
        var categoryTemplate1 = CategoryTemplate.builder().name("kategori template 1").url("kategori-template-1").build();
        var categoryTemplate2 = CategoryTemplate.builder().name("kategori template 2").url("kategori-template-2").build();
        var categoryTemplate3 = CategoryTemplate.builder().name("kategori template 3").url("kategori-template-3").build();
        categoryTemplateRepository.saveAll(Arrays.asList(categoryTemplate1,categoryTemplate2,categoryTemplate3));

        var category1 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori1").url("kategori1").build();
        var category2 = Category.builder().categoryTemplate(categoryTemplate2).name("kategori2").url("kategori2").build();
        var category3 = Category.builder().categoryTemplate(categoryTemplate3).name("kategori3").url("kategori3").build();
        var category4 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori4").url("kategori4").build();
        var category5 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori5").url("kategori5").build();
        categoryRepository.saveAll(List.of(category1,category2,category3,category4,category5));


        var category11 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori11").url("kategori11").parentCategory(category1).build();
        var category12 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori12").url("kategori12").parentCategory(category1).build();
        var category13 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori13").url("kategori13").parentCategory(category1).build();
        var category111 = Category.builder().categoryTemplate(categoryTemplate1).name("kategori111").url("kategori111").parentCategory(category11).build();

        categoryRepository.saveAll(Arrays.asList(category11,category12,category13, category111));

        var articleTemplate1 = ArticleTemplate.builder().categoryTemplate(categoryTemplate1).name("Article Temp 1").url("article-temp-1").build();
        var articleTemplate2 = ArticleTemplate.builder().categoryTemplate(categoryTemplate2).name("Article Temp 2").url("article-temp-2").build();
        var articleTemplate3 = ArticleTemplate.builder().categoryTemplate(categoryTemplate1).name("Article Temp 3").url("article-temp-3").build();
        articleTemplateRepository.saveAll(Arrays.asList(articleTemplate1,articleTemplate2,articleTemplate3));

        var article1 = MultiPageArticle.multiPageBuilder().
                articleTemplate(articleTemplate1).
                category(category1).
                content(LargeText.builder().text("large text content").build()).
                description("description").
                title("title").
                url("article1").
                keywords("keywords").
                name("name1").
                build();
        var article2 = MultiPageArticle.multiPageBuilder().
                articleTemplate(articleTemplate2).
                category(category2).
                content(LargeText.builder().text("large text content").build()).
                description("description").
                title("title").
                url("article2").
                keywords("keywords").
                name("name2").
                build();

        var article3 = SinglePageArticle.singlePageArticle().
                content(LargeText.builder().text("large text content").build()).
                description("description").
                title("title").
                url("singlePage").
                keywords("keywords").
                name("singlePage").
                build();

        articleRepository.saveAll(Arrays.asList(article1,article2,article3));

        for (int i = 4; i <= 1000; i++) {
            articleRepository.save(MultiPageArticle.multiPageBuilder().
                    articleTemplate(articleTemplate1).
                    category(category1).
                    content(LargeText.builder().text("large text content").build()).
                    description("description").
                    title("title").
                    url("article" + i).
                    keywords("keywords").
                    name("name" + i).
                    build());
        }

    }


}
