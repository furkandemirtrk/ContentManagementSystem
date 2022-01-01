package com.demirturk.cms.repository;

import com.demirturk.cms.entity.article.SinglePageArticle;
import com.demirturk.cms.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SinglePageArticleRepository extends JpaRepository<SinglePageArticle, Long> {
    List<SinglePageArticle> findAllByStatus(Status status);
}
