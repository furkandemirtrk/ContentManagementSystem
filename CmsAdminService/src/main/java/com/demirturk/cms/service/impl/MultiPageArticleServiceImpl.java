package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.Category;
import com.demirturk.cms.entity.article.MultiPageArticle;
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
        return Arrays.asList(modelMapper.map(multiPageArticleRepository.findAllByArticleTemplate(articleTemplate), ArticleDto[].class));
    }

    @Override
    public ArticleDto create(ArticleDto articleDto) throws CmsException {
        MultiPageArticle multiPageArticle = MultiPageArticle.multiPageBuilder().
                category(modelMapper.map(articleDto.getCategory(), Category.class)).
                articleTemplate(modelMapper.map(articleDto.getArticleTemplate(), ArticleTemplate.class)).
                name(articleDto.getName()).
                author(articleDto.getAuthor()).
                content(articleDto.getContent()).
                keywords(articleDto.getKeywords()).
                url(articleDto.getUrl()).
                description(articleDto.getDescription()).
                title(articleDto.getTitle()).
                build();
        return modelMapper.map(multiPageArticleRepository.save(multiPageArticle), ArticleDto.class);
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
