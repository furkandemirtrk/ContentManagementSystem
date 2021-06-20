package com.demirturk.cms.controller;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.CategoryTemplateDto;
import com.demirturk.cms.model.request.CheckCategoryTemplateUrlRequest;
import com.demirturk.cms.service.CategoryTemplateService;
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
@RequestMapping(ApiPaths.CategoryTemplateController.CONTROLLER)
@Api(value = ApiPaths.CategoryTemplateController.CONTROLLER)
public class CategoryTemplateController {

    private final CategoryTemplateService categoryTemplateService;

    @ApiOperation(value = "Get All CategoryTemplates", response = CategoryTemplateDto.class)
    @GetMapping("")
    public ResponseEntity<List<CategoryTemplateDto>> getAll() throws CmsException{
        return ResponseEntity.ok(categoryTemplateService.getAll());
    }

    @ApiOperation(value = "Create CategoryTemplate", response = CategoryTemplateDto.class)
    @PostMapping("")
    public ResponseEntity<CategoryTemplateDto> create(@RequestBody CategoryTemplateDto categoryTemplateDto) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.create(categoryTemplateDto));
    }

    @ApiOperation(value = "Update  CategoryTemplate", response = CategoryTemplateDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<CategoryTemplateDto> update(@RequestBody CategoryTemplateDto categoryTemplateDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.update(categoryTemplateDto, id));
    }

    @ApiOperation(value = "Delete  CategoryTemplate", response = Boolean.class)
    @PostMapping(ApiPaths.CategoryTemplateController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.delete(id));
    }

    @ApiOperation(value = "Check CategoryTemplate Url", response = Boolean.class)
    @PostMapping(ApiPaths.CategoryTemplateController.CHECK_URL)
    public ResponseEntity<Boolean> checkUrl(@RequestBody CheckCategoryTemplateUrlRequest checkCategoryTemplateUrlRequest) throws CmsException{
        return ResponseEntity.ok(categoryTemplateService.checkUrl(checkCategoryTemplateUrlRequest.getUrl()));
    }

    @ApiOperation(value = "Get All CategoryTemplates", response = CategoryTemplateDto.class)
    @GetMapping(ApiPaths.CategoryTemplateController.FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE)
    public ResponseEntity<List<CategoryTemplateDto>> findAllByArticleTemplateNotChoose() throws CmsException{
        return ResponseEntity.ok(categoryTemplateService.findAllByArticleTemplateNotChoose());
    }

    @ApiOperation(value = "CategoryTemplate Find By Url", response = CategoryTemplateDto.class)
    @GetMapping(ApiPaths.CategoryTemplateController.FIND_BY_URL + "/{url}")
    public ResponseEntity<CategoryTemplateDto> findByUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.findByUrl(url));
    }
}
