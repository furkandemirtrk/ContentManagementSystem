package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscontentservice.entity.article.SinglePageArticle;
import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.enums.Status;
import com.demirturk.cmscommons.exception.CmsException;
import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscontentservice.repository.SinglePageArticleRepository;
import com.demirturk.cmscontentservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service("singlePageArticleService")
public class SinglePageArticleServiceImpl implements ArticleService {

    private final SinglePageArticleRepository singlePageArticleRepository;

    @Override
    public List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) {
        return null;
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        SinglePageArticle singlePageArticle = SinglePageArticle.singlePageArticle().
                name(articleDto.getName()).
                author(articleDto.getAuthor()).
                content(CommonsModelMapper.getMapper().map(articleDto.getContent(), LargeText.class)).
                keywords(articleDto.getKeywords()).
                url(articleDto.getUrl()).
                description(articleDto.getDescription()).
                title(articleDto.getTitle()).
                build();
        return CommonsModelMapper.getMapper()
                .map(singlePageArticleRepository.save(singlePageArticle), ArticleDto.class);
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) throws CmsException {
        if (null == id || null == articleDto.getUrl() || articleDto.getUrl().isEmpty()){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        SinglePageArticle singlePageArticle = singlePageArticleRepository.getReferenceById(id);
        singlePageArticle.setKeywords(articleDto.getKeywords());
        singlePageArticle.setAuthor(articleDto.getAuthor());
        singlePageArticle.setContent(CommonsModelMapper.getMapper().map(articleDto.getContent(), LargeText.class));
        singlePageArticle.setUrl(articleDto.getUrl());
        singlePageArticle.setTitle(articleDto.getTitle());
        singlePageArticle.setDescription(articleDto.getDescription());
        singlePageArticle.setName(articleDto.getName());
        return CommonsModelMapper.getMapper()
                .map(singlePageArticleRepository.save(singlePageArticle), ArticleDto.class);
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }

    @Override
    public List<ArticleDto> findAllSinglePage() throws CmsException {
        return  Arrays.asList(CommonsModelMapper.getMapper()
                .map(singlePageArticleRepository.findAllByStatus(Status.ACTIVE), ArticleDto[].class));
    }

    @Override
    public ArticleDto findByUrl(String url) throws CmsException {
        return null;
    }

    @Override
    public boolean checkUrl(String url) throws CmsException {
        return false;
    }
}
