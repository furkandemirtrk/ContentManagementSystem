package com.demirturk.cms.service.impl;

import com.demirturk.cms.entity.Category;
import com.demirturk.cms.entity.CategoryTemplate;
import com.demirturk.cms.enums.ErrorCodeEnum;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryDto;
import com.demirturk.cms.repository.CategoryRepository;
import com.demirturk.cms.repository.CategoryTemplateRepository;
import com.demirturk.cms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTemplateRepository categoryTemplateRepository;
    private final ModelMapper modelMapper;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryDto> getAll() throws CmsException {
        return Arrays.asList(modelMapper.map(categoryRepository.findAll(), CategoryDto[].class));
    }

    /**
     *
     * @param categoryDto
     * @return
     * @throws CmsException
     */
    @Override
    public CategoryDto create(CategoryDto categoryDto) throws CmsException {
        if (categoryDto.getCategoryTemplate() == null || categoryDto.getName() == null || categoryDto.getName().equals("") || categoryDto.getUrl() == null || categoryDto.getUrl().equals(""))
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        CategoryTemplate categoryTemplate = categoryTemplateRepository.findCategoryTemplateByUrlAndName(categoryDto.getCategoryTemplate().getUrl(), categoryDto.getCategoryTemplate().getName());
        Category category =  modelMapper.map(categoryDto, Category.class);
        category.setCategoryTemplate(categoryTemplate);
        if (categoryDto.getParentCategory() != null){
            category.setParentCategory(categoryRepository.getById(categoryDto.getParentCategory().getId()));
        }
        return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
    }

    /**
     *
     * @param categoryDto
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public CategoryDto update(CategoryDto categoryDto, Long id) throws CmsException {
        if (id == null || categoryDto.getCategoryTemplate() == null || categoryDto.getName() == null || categoryDto.getName().equals("") || categoryDto.getUrl() == null || categoryDto.getUrl().equals(""))
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        Category category = categoryRepository.getById(id);
        category.setName(categoryDto.getName());
        category.setUrl(categoryDto.getUrl());
        return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
    }

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public boolean delete(Long id) throws CmsException {
        if (id == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        categoryRepository.delete(categoryRepository.getById(id));
        return true;
    }

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryDto> findFirstLevelCategoriesByCategoryTemplateId(Long id) throws CmsException {
        if (id == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return Arrays.asList(modelMapper.map(categoryRepository.findAllByCategoryTemplateIdAndParentCategoryIsNull(id), CategoryDto[].class));
    }

    /**
     *
     * @param id
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryDto> findAllByParentCategoryId(Long id) throws CmsException {
        if (id == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        return Arrays.asList(modelMapper.map(categoryRepository.findAllByParentCategoryId(id), CategoryDto[].class));
    }
}
