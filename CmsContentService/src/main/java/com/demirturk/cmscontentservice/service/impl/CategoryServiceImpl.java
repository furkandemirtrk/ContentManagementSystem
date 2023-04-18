package com.demirturk.cmscontentservice.service.impl;

import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import com.demirturk.cmscommons.exception.CmsException;
import com.demirturk.cmscommons.util.CommonsModelMapper;
import com.demirturk.cmscontentservice.entity.Category;
import com.demirturk.cmscontentservice.entity.CategoryTemplate;
import com.demirturk.cmscontentservice.model.dto.CategoryDto;
import com.demirturk.cmscontentservice.repository.CategoryRepository;
import com.demirturk.cmscontentservice.repository.CategoryTemplateRepository;
import com.demirturk.cmscontentservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTemplateRepository categoryTemplateRepository;

    /**
     *
     * @return
     * @throws CmsException
     */
    @Override
    public List<CategoryDto> getAll() throws CmsException {
        return Arrays.asList(CommonsModelMapper.getMapper()
                .map(categoryRepository.findAll(), CategoryDto[].class));
    }

    /**
     *
     * @param categoryDto
     * @return
     * @throws CmsException
     */
    @Override
    public CategoryDto create(CategoryDto categoryDto) throws CmsException {
        if (categoryDto.getCategoryTemplate() == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        CategoryTemplate categoryTemplate = categoryTemplateRepository.findCategoryTemplateByUrlAndName(
                categoryDto.getCategoryTemplate().getUrl(),
                categoryDto.getCategoryTemplate().getName());
        Category category =  CommonsModelMapper.getMapper().map(categoryDto, Category.class);
        category.setCategoryTemplate(categoryTemplate);
        if (categoryDto.getParentCategory() != null){
            category.setParentCategory(categoryRepository.getReferenceById(categoryDto.getParentCategory().getId()));
        }
        return CommonsModelMapper.getMapper().map(categoryRepository.save(category), CategoryDto.class);
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
        if (id == null || categoryDto.getCategoryTemplate() == null)
            throw new CmsException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);
        Category category = categoryRepository.getReferenceById(id);
        category.setName(categoryDto.getName());
        category.setUrl(categoryDto.getUrl());
        return CommonsModelMapper.getMapper().map(categoryRepository.save(category), CategoryDto.class);
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
        categoryRepository.delete(categoryRepository.getReferenceById(id));
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
        return Arrays.asList(CommonsModelMapper.getMapper()
                .map(categoryRepository.findAllByCategoryTemplateIdAndParentCategoryIsNull(id), CategoryDto[].class));
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
        return Arrays.asList(CommonsModelMapper.getMapper()
                .map(categoryRepository.findAllByParentCategoryId(id), CategoryDto[].class));
    }
}
