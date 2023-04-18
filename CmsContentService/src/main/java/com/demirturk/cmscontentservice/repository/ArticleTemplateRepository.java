package com.demirturk.cmscontentservice.repository;

import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTemplateRepository extends JpaRepository<ArticleTemplate, Long> {
    ArticleTemplate findByUrl(String url);
}
