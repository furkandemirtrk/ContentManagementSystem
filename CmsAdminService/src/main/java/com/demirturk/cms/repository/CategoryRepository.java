package com.demirturk.cms.repository;

import com.demirturk.cms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByCategoryTemplateIdAndParentCategoryIsNull(Long id);
    List<Category> findAllByParentCategoryId(Long id);
}
