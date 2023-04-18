package com.demirturk.cmscontentservice.service;


import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService  {
    ArticleDto create(ArticleDto articleDto) throws CmsException;

    ArticleDto update(ArticleDto articleDto, Long id) throws CmsException;

    boolean delete(Long id) throws CmsException;

    List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) throws CmsException;

    List<ArticleDto> findAllSinglePage() throws CmsException;

    ArticleDto findByUrl(String url) throws CmsException;

    boolean checkUrl(String url) throws CmsException;

}
