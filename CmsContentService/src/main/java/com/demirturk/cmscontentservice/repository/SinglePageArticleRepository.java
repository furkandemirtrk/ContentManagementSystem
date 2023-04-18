package com.demirturk.cmscontentservice.repository;

import com.demirturk.cmscontentservice.entity.article.SinglePageArticle;
import com.demirturk.cmscommons.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SinglePageArticleRepository extends JpaRepository<SinglePageArticle, Long> {
    List<SinglePageArticle> findAllByStatus(Status status);
}
