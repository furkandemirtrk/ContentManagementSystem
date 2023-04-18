package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import com.demirturk.cmscontentservice.entity.Category;
import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscontentservice.entity.article.MultiPageArticle;
import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.enums.Status;
import com.demirturk.cmscommons.exception.CmsException;
import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscontentservice.repository.ArticleTemplateRepository;
import com.demirturk.cmscontentservice.repository.MultiPageArticleRepository;
import com.demirturk.cmscontentservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service("multiPageArticleService")
public class MultiPageArticleServiceImpl implements ArticleService {

    private final MultiPageArticleRepository multiPageArticleRepository;
    private final ArticleTemplateRepository articleTemplateRepository;

    @Override
    public List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) {
        var articleTemplate = articleTemplateRepository.findByUrl(articleTemplateUrl);
        return Arrays.asList(CommonsModelMapper.getMapper().map(multiPageArticleRepository
                .findAllByArticleTemplateAndStatus(articleTemplate, Status.ACTIVE), ArticleDto[].class));
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        MultiPageArticle multiPageArticle = MultiPageArticle.multiPageBuilder().
                category(CommonsModelMapper.getMapper().map(articleDto.getCategory(), Category.class)).
                articleTemplate(CommonsModelMapper.getMapper().map(articleDto.getArticleTemplate(), ArticleTemplate.class)).
                name(articleDto.getName()).
                author(articleDto.getAuthor()).
                content(LargeText.builder().text(articleDto.getContent().getText()).build()).
                keywords(articleDto.getKeywords()).
                url(articleDto.getUrl()).
                description(articleDto.getDescription()).
                title(articleDto.getTitle()).
                build();
        return CommonsModelMapper.getMapper().map(multiPageArticleRepository.save(multiPageArticle), ArticleDto.class);
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) throws CmsException {
        if (null == id || null == articleDto.getUrl() || articleDto.getUrl().isEmpty()){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        MultiPageArticle multiPageArticle = multiPageArticleRepository.getById(id);
        multiPageArticle.setAuthor(articleDto.getAuthor());
        multiPageArticle.setName(articleDto.getName());
        multiPageArticle.setContent(CommonsModelMapper.getMapper().map(articleDto.getContent(), LargeText.class));
        multiPageArticle.setKeywords(articleDto.getKeywords());
        multiPageArticle.setUrl(articleDto.getUrl());
        multiPageArticle.setDescription(articleDto.getDescription());
        multiPageArticle.setTitle(articleDto.getTitle());
        multiPageArticle.setCategory(CommonsModelMapper.getMapper().map(articleDto.getCategory(), Category.class));
        return CommonsModelMapper.getMapper().map(multiPageArticleRepository.save(multiPageArticle), ArticleDto.class);
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }

    @Override
    public List<ArticleDto> findAllSinglePage() throws CmsException {
        return null;
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
