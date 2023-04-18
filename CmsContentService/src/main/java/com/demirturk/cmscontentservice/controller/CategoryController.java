package com.demirturk.cmscontentservice.controller;

import com.demirturk.cmscontentservice.util.ApiPaths;
import com.demirturk.cmscontentservice.model.dto.CategoryDto;
import com.demirturk.cmscontentservice.model.request.FindAllByParentCategoryIdRequest;
import com.demirturk.cmscontentservice.model.request.FindFirstLevelCategoriesByCategoryTemplateIdRequest;
import com.demirturk.cmscontentservice.service.CategoryService;
import com.demirturk.cmscommons.exception.CmsException;
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
//@Api(value = ApiPaths.CategoryController.CONTROLLER)
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAll() throws CmsException {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) throws CmsException {
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryService.update(categoryDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryService.delete(id));
    }

    @PostMapping(ApiPaths.CategoryController.FIND_ALL_BY_PARENT_CATEGORY)
    public ResponseEntity<List<CategoryDto>> findAllByParentCategoryId(@RequestBody FindAllByParentCategoryIdRequest findAllByParentCategoryIdRequest) throws CmsException {
        return ResponseEntity.ok(categoryService.findAllByParentCategoryId(findAllByParentCategoryIdRequest.getId()));
    }

    @PostMapping(ApiPaths.CategoryController.FIND_FIRST_LEVEL_CATEGORIES_BY_CATEGORY_TEMPLATE)
    public ResponseEntity<List<CategoryDto>> findFirstLevelCategoriesByCategoryTemplateId(@RequestBody FindFirstLevelCategoriesByCategoryTemplateIdRequest findFirstLevelCategoriesByCategoryTemplateIdRequest) throws CmsException {
        return ResponseEntity.ok(categoryService.findFirstLevelCategoriesByCategoryTemplateId(findFirstLevelCategoriesByCategoryTemplateIdRequest.getCategoryTemplateId()));
    }
}
