package com.demirturk.cms.service;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleTemplateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleTemplateService {
    /**
     *
     * @return
     * @throws CmsException
     */
    List<ArticleTemplateDto> getAll() throws CmsException;

    /**
     *
     * @param articleTemplateDto
     * @return
     * @throws CmsException
     */
    ArticleTemplateDto create(ArticleTemplateDto articleTemplateDto) throws CmsException;

    /**
     *
     * @param articleTemplateDto
     * @param id
     * @return
     * @throws CmsException
     */
    ArticleTemplateDto update(ArticleTemplateDto articleTemplateDto, Long id) throws CmsException;

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
}
