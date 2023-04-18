package com.demirturk.cmscontentservice.service;

import com.demirturk.cmscontentservice.model.dto.ArticleTemplateDto;
import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleTemplateService {
    List<ArticleTemplateDto> getAll() throws CmsException;

    ArticleTemplateDto create(ArticleTemplateDto articleTemplateDto) throws CmsException;

    ArticleTemplateDto update(ArticleTemplateDto articleTemplateDto, Long id) throws CmsException;

    boolean delete(Long id) throws CmsException;

    boolean checkUrl(String url) throws CmsException;
}
