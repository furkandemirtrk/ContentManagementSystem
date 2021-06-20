package com.demirturk.cms.repository;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.article.MultiPageArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiPageArticleRepository extends JpaRepository<MultiPageArticle, Long> {
    List<MultiPageArticle> findAllByArticleTemplate(ArticleTemplate articleTemplate);
}
