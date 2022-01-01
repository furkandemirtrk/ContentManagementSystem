package com.demirturk.cms.service;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService  {
    /**
     *
     * @param articleDto
     * @return
     * @throws CmsException
     */
    ArticleDto create(ArticleDto articleDto) throws CmsException;

    /**
     *
     * @param articleDto
     * @param id
     * @return
     * @throws CmsException
     */
    ArticleDto update(ArticleDto articleDto, Long id) throws CmsException;

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    boolean delete(Long id) throws CmsException;

    /**
     *
     * @param articleTemplateUrl
     * @return
     * @throws CmsException
     */
    List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) throws CmsException;

    /**
     *
     * @return
     * @throws CmsException
     */
    List<ArticleDto> findAllSinglePage() throws CmsException;

    /**
     *
     * @return
     * @throws CmsException
     * @param url
     */

    ArticleDto findByUrl(String url) throws CmsException;

    /**
     *
     * @param url
     * @return
     * @throws CmsException
     */
    boolean checkUrl(String url) throws CmsException;

}
