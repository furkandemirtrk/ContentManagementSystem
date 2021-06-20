package com.demirturk.cms.service;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    /**
     *
     * @return
     * @throws CmsException
     */
    List<CategoryDto> getAll() throws CmsException;

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    List<CategoryDto> findFirstLevelCategoriesByCategoryTemplateId(Long id) throws CmsException;

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    List<CategoryDto> findAllByParentCategoryId(Long id) throws CmsException;

    /**
     *
     * @param categoryDto
     * @return
     * @throws CmsException
     */
    CategoryDto create(CategoryDto categoryDto) throws CmsException;

    /**
     *
     * @param categoryDto
     * @param id
     * @return
     * @throws CmsException
     */
    CategoryDto update(CategoryDto categoryDto, Long id) throws CmsException;

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    boolean delete(Long id) throws CmsException;
}
