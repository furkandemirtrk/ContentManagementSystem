package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.article.Article;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.enums.Status;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.repository.ArticleRepository;
import com.demirturk.cms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

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
    public List<ArticleDto> findAllSinglePage() throws CmsException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        log.info("ArticleServiceImpl delete start");
        try {
            Article article = articleRepository.getById(id);
            article.setStatus(Status.PASSIVE);
            articleRepository.save(article);
            log.info("ArticleServiceImpl delete end");
            return true;
        } catch (Exception e) {
            log.info("ArticleServiceImpl delete error", e);
            return false;
        }
    }

    @Override
    public ArticleDto findByUrl(String url) throws CmsException {
        if (null == url || url.isEmpty())
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return modelMapper.map(articleRepository.findByUrl(url), ArticleDto.class);
    }

    @Override
    public boolean checkUrl(String url) throws CmsException {
        if (null == url || url.isEmpty())
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return articleRepository.findByUrl(url) == null;
    }
}
