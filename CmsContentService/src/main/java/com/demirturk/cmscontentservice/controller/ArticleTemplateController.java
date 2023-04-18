package com.demirturk.cmscontentservice.controller;

import com.demirturk.cmscontentservice.util.ApiPaths;
import com.demirturk.cmscontentservice.model.dto.ArticleTemplateDto;
import com.demirturk.cmscontentservice.model.request.CheckArticleTemplateUrlRequest;
import com.demirturk.cmscontentservice.service.ArticleTemplateService;
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
@RequestMapping(ApiPaths.ArticleTemplateController.CONTROLLER)
public class ArticleTemplateController {

    private final ArticleTemplateService articleTemplateService;

    @GetMapping("")
    public ResponseEntity<List<ArticleTemplateDto>> getAll() throws CmsException {
        return ResponseEntity.ok(articleTemplateService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<ArticleTemplateDto> create(@RequestBody ArticleTemplateDto articleTemplateDto) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.create(articleTemplateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleTemplateDto> update(@RequestBody ArticleTemplateDto articleTemplateDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.update(articleTemplateDto, id));
    }

    @PostMapping(ApiPaths.ArticleTemplateController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.delete(id));
    }

    @PostMapping(ApiPaths.ArticleTemplateController.CHECK_URL)
    public ResponseEntity<Boolean> checkUrl(@RequestBody CheckArticleTemplateUrlRequest checkArticleTemplateUrlRequest) throws CmsException{
        return ResponseEntity.ok(articleTemplateService.checkUrl(checkArticleTemplateUrlRequest.getUrl()));
    }
}
