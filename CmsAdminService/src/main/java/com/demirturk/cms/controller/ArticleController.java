package com.demirturk.cms.controller;

import com.demirturk.cms.enums.ArticleType;
import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.factory.ArticleServiceFactory;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.model.request.FindAllArticleByArticleTemplateUrlRequest;
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
@RequestMapping(ApiPaths.ArticleController.CONTROLLER)
@Api(value = ApiPaths.ArticleController.CONTROLLER)
public class ArticleController {

    private final ArticleServiceFactory articleServiceFactory;

    @ApiOperation(value = "Find All Article By Article Template Url", response = ArticleDto.class)
    @PostMapping(ApiPaths.ArticleController.FIND_ALL_BY_ARTICLE_TEMPLATE)
    public ResponseEntity<List<ArticleDto>> findAllArticleByArticleTemplateUrl(@RequestBody FindAllArticleByArticleTemplateUrlRequest findAllArticleByArticleTemplateUrlRequest) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.MULTI_PAGE_ARTICLE).findAllByArticleTemplate(findAllArticleByArticleTemplateUrlRequest.getUrl()));
    }

    @ApiOperation(value = "Create Article", response = ArticleDto.class)
    @PostMapping
    public ResponseEntity<ArticleDto> create(@RequestBody ArticleDto articleDto) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(articleDto.getArticleType().name()).create(articleDto));
    }

    @ApiOperation(value = "Update Article", response = ArticleDto.class)
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> update(@RequestBody ArticleDto articleDto, @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(articleDto.getArticleType().name()).update(articleDto, id));
    }
}
