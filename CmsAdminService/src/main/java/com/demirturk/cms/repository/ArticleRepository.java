package com.demirturk.cms.repository;

import com.demirturk.cms.entity.article.Article;
import com.demirturk.cms.entity.article.MultiPageArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByUrl(String url);
}
