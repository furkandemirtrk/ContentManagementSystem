package com.demirturk.cms.repository;

import com.demirturk.cms.entity.article.SinglePageArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinglePageArticleRepository extends JpaRepository<SinglePageArticle, Long> {
}
