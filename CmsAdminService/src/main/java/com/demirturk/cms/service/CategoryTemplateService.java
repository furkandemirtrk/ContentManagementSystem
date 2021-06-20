package com.demirturk.cms.service;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryTemplateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryTemplateService {
    /**
     *
     * @return
     * @throws CmsException
     */
    List<CategoryTemplateDto> getAll() throws CmsException;

    /**
     *
     * @param categoryTemplateDto
     * @return
     * @throws CmsException
     */
    CategoryTemplateDto create(CategoryTemplateDto categoryTemplateDto) throws CmsException;

    /**
     *
     * @param categoryTemplateDto
     * @param id
     * @return
     * @throws CmsException
     */
    CategoryTemplateDto update(CategoryTemplateDto categoryTemplateDto, Long id) throws CmsException;

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    boolean delete(Long id) throws CmsException;

    /**
     *
     * @param url
     * @return
     * @throws CmsException
     */
    boolean checkUrl(String url) throws CmsException;

    /**
     *
     * @return
     * @throws CmsException
     */
    List<CategoryTemplateDto> findAllByArticleTemplateNotChoose() throws CmsException;

    /**
     *
     * @param url
     * @return
     * @throws CmsException
     */
    CategoryTemplateDto findByUrl(String url) throws CmsException;
}
