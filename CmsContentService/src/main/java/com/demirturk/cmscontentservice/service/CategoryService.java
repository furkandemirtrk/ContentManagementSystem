package com.demirturk.cmscontentservice.service;

import com.demirturk.cmscontentservice.model.dto.CategoryDto;
import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDto> getAll() throws CmsException;

    List<CategoryDto> findFirstLevelCategoriesByCategoryTemplateId(Long id) throws CmsException;

    List<CategoryDto> findAllByParentCategoryId(Long id) throws CmsException;

    CategoryDto create(CategoryDto categoryDto) throws CmsException;

    CategoryDto update(CategoryDto categoryDto, Long id) throws CmsException;

    boolean delete(Long id) throws CmsException;
}
