package com.demirturk.cmscontentservice.repository;

import com.demirturk.cmscontentservice.entity.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByUrl(String url);
}
