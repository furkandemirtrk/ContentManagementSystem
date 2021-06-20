package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.CategoryTemplate;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleTemplateDto;
import com.demirturk.cms.repository.ArticleTemplateRepository;
import com.demirturk.cms.repository.CategoryTemplateRepository;
import com.demirturk.cms.service.ArticleTemplateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleTemplateServiceImpl implements ArticleTemplateService {

    private final ArticleTemplateRepository articleTemplateRepository;
    private final CategoryTemplateRepository categoryTemplateRepository;
    private final ModelMapper modelMapper;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<ArticleTemplateDto> getAll() throws CmsException {
        return Arrays.asList(modelMapper.map(articleTemplateRepository.findAll(), ArticleTemplateDto[].class));
    }

    /**
     *
     * @param articleTemplateDto
     * @return
     * @throws CmsException
     */
    @Override
    public ArticleTemplateDto create(ArticleTemplateDto articleTemplateDto) throws CmsException {
        if (articleTemplateDto == null || articleTemplateDto.getCategoryTemplate() == null || articleTemplateDto.getName() == null ||articleTemplateDto.getName().equals("") || articleTemplateDto.getUrl().equals("") || articleTemplateDto.getUrl() == null){
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        }
        CategoryTemplate categoryTemplate = categoryTemplateRepository.getById(articleTemplateDto.getCategoryTemplate().getId());
        ArticleTemplate articleTemplate = modelMapper.map(articleTemplateDto, ArticleTemplate.class);
        articleTemplate.setCategoryTemplate(categoryTemplate);
        return modelMapper.map(articleTemplateRepository.save(articleTemplate), ArticleTemplateDto.class);
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
        return modelMapper.map(articleTemplateRepository.save(articleTemplate), ArticleTemplateDto.class);
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
