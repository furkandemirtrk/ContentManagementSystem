package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.ArticleTemplate;
import com.demirturk.cmscontentservice.model.dto.ArticleTemplateDto;
import com.demirturk.cmscontentservice.repository.ArticleTemplateRepository;
import com.demirturk.cmscontentservice.repository.CategoryTemplateRepository;
import com.demirturk.cmscontentservice.service.ArticleTemplateService;
import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.exception.CmsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleTemplateServiceImpl implements ArticleTemplateService {

    private final ArticleTemplateRepository articleTemplateRepository;
    private final CategoryTemplateRepository categoryTemplateRepository;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<ArticleTemplateDto> getAll() throws CmsException {
        return Arrays.asList(CommonsModelMapper.getMapper().map(articleTemplateRepository.findAll(), ArticleTemplateDto[].class));
    }

    /**
     *
     * @param articleTemplateDto
     * @return
     * @throws CmsException
     */
    @Override
    public ArticleTemplateDto create(ArticleTemplateDto articleTemplateDto) throws CmsException {
        if (articleTemplateDto == null ||  articleTemplateDto.getName() == null || articleTemplateDto.getName().isEmpty() || articleTemplateDto.getUrl().isEmpty() || articleTemplateDto.getUrl() == null){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        if (articleTemplateDto.isUseCategory() && articleTemplateDto.getCategoryTemplate() == null){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        ArticleTemplate articleTemplate = CommonsModelMapper.getMapper().map(articleTemplateDto, ArticleTemplate.class);
        if (articleTemplateDto.isUseCategory()){
            articleTemplate.setCategoryTemplate(categoryTemplateRepository.getById(articleTemplateDto.getCategoryTemplate().getId()));
        }
        return CommonsModelMapper.getMapper().map(articleTemplateRepository.save(articleTemplate), ArticleTemplateDto.class);
    }

    /**
     *
     * @param articleTemplateDto
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public ArticleTemplateDto update(ArticleTemplateDto articleTemplateDto, Long id) throws CmsException {
        if (id == null || articleTemplateDto == null || articleTemplateDto.getName() == null ||articleTemplateDto.getName().equals("") || articleTemplateDto.getUrl().equals("") || articleTemplateDto.getUrl() == null){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        var articleTemplate = articleTemplateRepository.getById(id);
        articleTemplate.setName(articleTemplateDto.getName());
        articleTemplate.setUrl(articleTemplateDto.getUrl());
        return CommonsModelMapper.getMapper().map(articleTemplateRepository.save(articleTemplate), ArticleTemplateDto.class);
    }

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public boolean delete(Long id) throws CmsException {
        if (id == null){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        articleTemplateRepository.deleteById(id);
        return true;
    }

    /**
     *
     * @param url
     * @return
     * @throws CmsException
     */
    @Override
    public boolean checkUrl(String url) throws CmsException {
        if (url.isEmpty())
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return articleTemplateRepository.findByUrl(url) == null;
    }
}
