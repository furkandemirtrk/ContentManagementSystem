package com.demirturk.cms.controller;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryDto;
import com.demirturk.cms.model.request.FindAllByParentCategoryIdRequest;
import com.demirturk.cms.model.request.FindFirstLevelCategoriesByCategoryTemplateIdRequest;
import com.demirturk.cms.service.CategoryService;
import com.demirturk.cms.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.CategoryController.CONTROLLER)
@Api(value = ApiPaths.CategoryController.CONTROLLER)
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Get All Categories", response = CategoryDto.class)
    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAll() throws CmsException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @ApiOperation(value = "Create Category", response = CategoryDto.class)
    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) throws CmsException {
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }

    @ApiOperation(value = "Update  Category", response = CategoryDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryService.update(categoryDto, id));
    }

    @ApiOperation(value = "Delete  Category", response = Boolean.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryService.delete(id));
    }

    @ApiOperation(value = "Find All By Parent Category Id", response = CategoryDto.class)
    @PostMapping(ApiPaths.CategoryController.FIND_ALL_BY_PARENT_CATEGORY)
    public ResponseEntity<List<CategoryDto>> findAllByParentCategoryId(@RequestBody FindAllByParentCategoryIdRequest findAllByParentCategoryIdRequest) throws CmsException {
        return ResponseEntity.ok(categoryService.findAllByParentCategoryId(findAllByParentCategoryIdRequest.getId()));
    }

    @ApiOperation(value = "Find First Level Categories By Category Template Id", response = CategoryDto.class)
    @PostMapping(ApiPaths.CategoryController.FIND_FIRST_LEVEL_CATEGORIES_BY_CATEGORY_TEMPLATE)
    public ResponseEntity<List<CategoryDto>> findFirstLevelCategoriesByCategoryTemplateId(@RequestBody FindFirstLevelCategoriesByCategoryTemplateIdRequest findFirstLevelCategoriesByCategoryTemplateIdRequest) throws CmsException {
        return ResponseEntity.ok(categoryService.findFirstLevelCategoriesByCategoryTemplateId(findFirstLevelCategoriesByCategoryTemplateIdRequest.getCategoryTemplateId()));
    }
}
