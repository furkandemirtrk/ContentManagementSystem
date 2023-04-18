package com.demirturk.cmscontentservice.repository;

import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import com.demirturk.cmscontentservice.entity.article.MultiPageArticle;
import com.demirturk.cmscommons.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiPageArticleRepository extends JpaRepository<MultiPageArticle, Long> {
    List<MultiPageArticle> findAllByArticleTemplateAndStatus(ArticleTemplate articleTemplate, Status status);
}
