package com.demirturk.cms.controller;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleTemplateDto;
import com.demirturk.cms.model.request.CheckArticleTemplateUrlRequest;
import com.demirturk.cms.service.ArticleTemplateService;
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
@RequestMapping(ApiPaths.ArticleTemplateController.CONTROLLER)
@Api(value = ApiPaths.ArticleTemplateController.CONTROLLER)
public class ArticleTemplateController {

    private final ArticleTemplateService articleTemplateService;

    @ApiOperation(value = "Get All ArticleTemplates", response = ArticleTemplateDto.class)
    @GetMapping("")
    public ResponseEntity<List<ArticleTemplateDto>> getAll() throws CmsException{
        return ResponseEntity.ok(articleTemplateService.getAll());
    }

    @ApiOperation(value = "Create ArticleTemplate", response = ArticleTemplateDto.class)
    @PostMapping("")
    public ResponseEntity<ArticleTemplateDto> create(@RequestBody ArticleTemplateDto articleTemplateDto) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.create(articleTemplateDto));
    }

    @ApiOperation(value = "Update  ArticleTemplate", response = ArticleTemplateDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<ArticleTemplateDto> update(@RequestBody ArticleTemplateDto articleTemplateDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.update(articleTemplateDto, id));
    }

    @ApiOperation(value = "Delete  ArticleTemplate", response = Boolean.class)
    @PostMapping(ApiPaths.ArticleTemplateController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleTemplateService.delete(id));
    }

    @ApiOperation(value = "Check CategoryTemplate Url", response = Boolean.class)
    @PostMapping(ApiPaths.ArticleTemplateController.CHECK_URL)
    public ResponseEntity<Boolean> checkUrl(@RequestBody CheckArticleTemplateUrlRequest checkArticleTemplateUrlRequest) throws CmsException{
        return ResponseEntity.ok(articleTemplateService.checkUrl(checkArticleTemplateUrlRequest.getUrl()));
    }
}
