package com.demirturk.cmscontentservice.controller;

import com.demirturk.cmscontentservice.util.ApiPaths;
import com.demirturk.cmscontentservice.model.dto.CategoryTemplateDto;
import com.demirturk.cmscontentservice.model.request.CheckCategoryTemplateUrlRequest;
import com.demirturk.cmscontentservice.service.CategoryTemplateService;
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
@RequestMapping(ApiPaths.CategoryTemplateController.CONTROLLER)
public class CategoryTemplateController {

    private final CategoryTemplateService categoryTemplateService;

    @GetMapping("")
    public ResponseEntity<List<CategoryTemplateDto>> getAll() throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<CategoryTemplateDto> create(@RequestBody CategoryTemplateDto categoryTemplateDto) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.create(categoryTemplateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryTemplateDto> update(@RequestBody CategoryTemplateDto categoryTemplateDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.update(categoryTemplateDto, id));
    }

    @PostMapping(ApiPaths.CategoryTemplateController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.delete(id));
    }

    @PostMapping(ApiPaths.CategoryTemplateController.CHECK_URL)
    public ResponseEntity<Boolean> checkUrl(@RequestBody CheckCategoryTemplateUrlRequest checkCategoryTemplateUrlRequest) throws CmsException{
        return ResponseEntity.ok(categoryTemplateService.checkUrl(checkCategoryTemplateUrlRequest.getUrl()));
    }

    @GetMapping(ApiPaths.CategoryTemplateController.FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE)
    public ResponseEntity<List<CategoryTemplateDto>> findAllByArticleTemplateNotChoose() throws CmsException{
        return ResponseEntity.ok(categoryTemplateService.findAllByArticleTemplateNotChoose());
    }

    @GetMapping(ApiPaths.CategoryTemplateController.FIND_BY_URL + "/{url}")
    public ResponseEntity<CategoryTemplateDto> findByUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(categoryTemplateService.findByUrl(url));
    }
}
