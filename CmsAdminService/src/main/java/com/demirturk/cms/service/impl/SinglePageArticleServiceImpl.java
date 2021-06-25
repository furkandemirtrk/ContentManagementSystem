package com.demirturk.cms.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.demirturk.cms.entity.article.SinglePageArticle;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.enums.Status;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.repository.SinglePageArticleRepository;
import com.demirturk.cms.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("singlePageArticleService")
public class SinglePageArticleServiceImpl implements ArticleService {

    private final SinglePageArticleRepository singlePageArticleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) {
        return null;
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        SinglePageArticle singlePageArticle = SinglePageArticle.singlePageArticle().
                name(articleDto.getName()).
                author(articleDto.getAuthor()).
                content(articleDto.getContent()).
                keywords(articleDto.getKeywords()).
                url(articleDto.getUrl()).
                description(articleDto.getDescription()).
                title(articleDto.getTitle()).
                build();
        return modelMapper.map(singlePageArticleRepository.save(singlePageArticle), ArticleDto.class );
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) throws CmsException {
        if (null == id || null == articleDto.getUrl() || articleDto.getUrl().isEmpty()){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        SinglePageArticle singlePageArticle = singlePageArticleRepository.getById(id);
        singlePageArticle.setKeywords(articleDto.getKeywords());
        singlePageArticle.setAuthor(articleDto.getAuthor());
        singlePageArticle.setContent(articleDto.getContent());
        singlePageArticle.setUrl(articleDto.getUrl());
        singlePageArticle.setTitle(articleDto.getTitle());
        singlePageArticle.setDescription(articleDto.getDescription());
        singlePageArticle.setName(articleDto.getName());
        return modelMapper.map(singlePageArticleRepository.save(singlePageArticle), ArticleDto.class);
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }
}
