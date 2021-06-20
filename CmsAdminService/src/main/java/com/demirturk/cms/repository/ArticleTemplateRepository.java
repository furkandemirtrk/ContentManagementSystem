package com.demirturk.cms.repository;

import com.demirturk.cms.entity.ArticleTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTemplateRepository extends JpaRepository<ArticleTemplate, Long> {
    ArticleTemplate findByUrl(String url);
}
