package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.Category;
import com.demirturk.cms.entity.LargeText;
import com.demirturk.cms.entity.article.MultiPageArticle;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.enums.Status;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.repository.ArticleTemplateRepository;
import com.demirturk.cms.repository.MultiPageArticleRepository;
import com.demirturk.cms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service("multiPageArticleService")
public class MultiPageArticleServiceImpl implements ArticleService {

    private final MultiPageArticleRepository multiPageArticleRepository;
    private final ArticleTemplateRepository articleTemplateRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ArticleDto> findAllByArticleTemplate(String articleTemplateUrl) {
        var articleTemplate = articleTemplateRepository.findByUrl(articleTemplateUrl);
        return Arrays.asList(modelMapper.map(multiPageArticleRepository
                .findAllByArticleTemplateAndStatus(articleTemplate, Status.ACTIVE), ArticleDto[].class));
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        MultiPageArticle multiPageArticle = MultiPageArticle.multiPageBuilder().
                category(modelMapper.map(articleDto.getCategory(), Category.class)).
                articleTemplate(modelMapper.map(articleDto.getArticleTemplate(), ArticleTemplate.class)).
                name(articleDto.getName()).
                author(articleDto.getAuthor()).
                content(LargeText.builder().text(articleDto.getContent().getText()).build()).
                keywords(articleDto.getKeywords()).
                url(articleDto.getUrl()).
                description(articleDto.getDescription()).
                title(articleDto.getTitle()).
                build();
        return modelMapper.map(multiPageArticleRepository.save(multiPageArticle), ArticleDto.class);
    }

    @Override
    public ArticleDto update(ArticleDto articleDto, Long id) throws CmsException {
        if (null == id || null == articleDto.getUrl() || articleDto.getUrl().isEmpty()){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        MultiPageArticle multiPageArticle = multiPageArticleRepository.getById(id);
        multiPageArticle.setAuthor(articleDto.getAuthor());
        multiPageArticle.setName(articleDto.getName());
        multiPageArticle.setContent(modelMapper.map(articleDto.getContent(), LargeText.class));
        multiPageArticle.setKeywords(articleDto.getKeywords());
        multiPageArticle.setUrl(articleDto.getUrl());
        multiPageArticle.setDescription(articleDto.getDescription());
        multiPageArticle.setTitle(articleDto.getTitle());
        multiPageArticle.setCategory(modelMapper.map(articleDto.getCategory(), Category.class));
        return modelMapper.map(multiPageArticleRepository.save(multiPageArticle), ArticleDto.class);
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
