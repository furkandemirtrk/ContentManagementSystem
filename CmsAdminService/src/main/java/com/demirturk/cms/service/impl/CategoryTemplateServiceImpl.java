package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.CategoryTemplate;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.enums.Status;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryTemplateDto;
import com.demirturk.cms.repository.CategoryTemplateRepository;
import com.demirturk.cms.service.CategoryTemplateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryTemplateServiceImpl implements CategoryTemplateService {

    private final CategoryTemplateRepository categoryTemplateRepository;
    private final ModelMapper modelMapper;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryTemplateDto> getAll() throws CmsException {
        return Arrays.asList(modelMapper.map(categoryTemplateRepository.findAllByStatus(Status.ACTIVE),CategoryTemplateDto[].class));
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
        return modelMapper.map(categoryTemplateRepository.save(modelMapper.map(categoryTemplateDto, CategoryTemplate.class)), CategoryTemplateDto.class);
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
        if(id == null || categoryTemplateDto.getName() == null || categoryTemplateDto.getName().equals("") || categoryTemplateDto.getUrl() == null || categoryTemplateDto.getUrl().equals(""))
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        CategoryTemplate categoryTemplate = categoryTemplateRepository.getById(id);
        categoryTemplate.setName(categoryTemplateDto.getName());
        categoryTemplate.setUrl(categoryTemplateDto.getUrl());
        return modelMapper.map(categoryTemplateRepository.save(categoryTemplate), CategoryTemplateDto.class);
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
        CategoryTemplate categoryTemplate = categoryTemplateRepository.getById(id);
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
        return Arrays.asList(modelMapper.map(categoryTemplateRepository.findAllByArticleTemplateNotChoose(Status.ACTIVE), CategoryTemplateDto[].class));
    }

    @Override
    public CategoryTemplateDto findByUrl(String url) throws CmsException {
        return modelMapper.map(categoryTemplateRepository.findByUrl(url), CategoryTemplateDto.class);
    }
}
