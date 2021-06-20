package com.demirturk.cms.repository;

import com.demirturk.cms.entity.CategoryTemplate;
import com.demirturk.cms.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTemplateRepository extends JpaRepository<CategoryTemplate,Long> {
    CategoryTemplate findCategoryTemplateByUrlAndName(String url, String name);
    CategoryTemplate findByUrl(String url);
    List<CategoryTemplate> findAllByStatus(Status status);

    /**
     * findAllByArticleTemplateNotChoose
     * @param status
     * @return
     */
    @Query(value = "SELECT ct from CategoryTemplate ct where ct.id not in ( select  at.categoryTemplate.id from ArticleTemplate at ) and ct.status = :status")
    List<CategoryTemplate> findAllByArticleTemplateNotChoose(@Param("status") Status status);
}
