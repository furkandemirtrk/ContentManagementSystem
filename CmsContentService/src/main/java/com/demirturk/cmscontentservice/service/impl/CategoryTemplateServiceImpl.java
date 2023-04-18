package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.CategoryTemplate;
import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.enums.Status;
import com.demirturk.cmscommons.exception.CmsException;
import com.demirturk.cmscontentservice.model.dto.CategoryTemplateDto;
import com.demirturk.cmscontentservice.repository.CategoryTemplateRepository;
import com.demirturk.cmscontentservice.service.CategoryTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryTemplateServiceImpl implements CategoryTemplateService {

    private final CategoryTemplateRepository categoryTemplateRepository;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryTemplateDto> getAll() throws CmsException {
        return Arrays.asList(CommonsModelMapper.getMapper()
                .map(categoryTemplateRepository.findAllByStatus(Status.ACTIVE),CategoryTemplateDto[].class));
    }

    /**
     *
     * @param categoryTemplateDto
     * @return
     * @throws CmsException
     */
    @Override
    public CategoryTemplateDto create(CategoryTemplateDto categoryTemplateDto) throws CmsException{
        if(categoryTemplateDto.getName() == null || categoryTemplateDto.getName().equals(""))
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return CommonsModelMapper.getMapper()
                .map(categoryTemplateRepository.save(
                        CommonsModelMapper.getMapper().map(categoryTemplateDto, CategoryTemplate.class)),
                        CategoryTemplateDto.class);
    }

    /**
     *
     * @param categoryTemplateDto
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public CategoryTemplateDto update(CategoryTemplateDto categoryTemplateDto, Long id) throws CmsException{
        if(id == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        CategoryTemplate categoryTemplate = categoryTemplateRepository.getReferenceById(id);
        categoryTemplate.setName(categoryTemplateDto.getName());
        categoryTemplate.setUrl(categoryTemplateDto.getUrl());
        return CommonsModelMapper.getMapper()
                .map(categoryTemplateRepository.save(categoryTemplate), CategoryTemplateDto.class);
    }

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public boolean delete(Long id) throws CmsException {
        if(id == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        CategoryTemplate categoryTemplate = categoryTemplateRepository.getReferenceById(id);
        categoryTemplate.setStatus(Status.PASSIVE);
        categoryTemplateRepository.save(categoryTemplate);
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
        return categoryTemplateRepository.findByUrl(url) == null;
    }

    /**
     * findAllByArticleTemplateNotChoose
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryTemplateDto> findAllByArticleTemplateNotChoose() throws CmsException {
        return Arrays.asList(CommonsModelMapper.getMapper().map(
                categoryTemplateRepository
                        .findAllByArticleTemplateNotChoose(Status.ACTIVE), CategoryTemplateDto[].class));
    }

    @Override
    public CategoryTemplateDto findByUrl(String url) throws CmsException {
        return CommonsModelMapper.getMapper()
                .map(categoryTemplateRepository.findByUrl(url), CategoryTemplateDto.class);
    }
}
