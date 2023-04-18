package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.article.Article;
import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.enums.Status;
import com.demirturk.cmscommons.exception.CmsException;
import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscontentservice.repository.ArticleRepository;
import com.demirturk.cmscontentservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public List<ArticleDto> findAllSinglePage() throws CmsException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        log.info("ArticleServiceImpl delete start");
        try {
            Article article = articleRepository.getReferenceById(id);
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
        return CommonsModelMapper.getMapper().map(articleRepository.findByUrl(url), ArticleDto.class);
    }

    @Override
    public boolean checkUrl(String url) throws CmsException {
        if (null == url || url.isEmpty())
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return articleRepository.findByUrl(url) == null;
    }
}
