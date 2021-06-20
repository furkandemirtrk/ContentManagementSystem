package com.demirturk.cms.service;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    ArticleDto create(ArticleDto articleDto) throws CmsException;
    ArticleDto update(ArticleDto articleDto, Long id) throws CmsException;
    boolean delete(Long id) throws CmsException;
    List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) throws CmsException;
}
