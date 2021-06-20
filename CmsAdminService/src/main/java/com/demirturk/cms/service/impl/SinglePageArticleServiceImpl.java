package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.article.SinglePageArticle;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.repository.ArticleTemplateRepository;
import com.demirturk.cms.repository.MultiPageArticleRepository;
import com.demirturk.cms.repository.SinglePageArticleRepository;
import com.demirturk.cms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }
}
