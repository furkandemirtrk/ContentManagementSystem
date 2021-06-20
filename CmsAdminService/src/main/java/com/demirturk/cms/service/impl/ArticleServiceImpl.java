package com.demirturk.cms.service.impl;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.repository.ArticleRepository;
import com.demirturk.cms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) {
        return null;
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        return null;
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) throws CmsException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }
}
