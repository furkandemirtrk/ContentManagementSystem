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

    @ApiOperation(value = "Find All Multi Page Article By Article Template Url", response = ArticleDto.class)
    @PostMapping(ApiPaths.ArticleController.FIND_ALL_BY_ARTICLE_TEMPLATE)
    public ResponseEntity<List<ArticleDto>> findAllMultiPageArticleByArticleTemplateUrl(@RequestBody FindAllArticleByArticleTemplateUrlRequest findAllArticleByArticleTemplateUrlRequest) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.MULTI_PAGE_ARTICLE).findAllByArticleTemplate(findAllArticleByArticleTemplateUrlRequest.getUrl()));
    }

    @ApiOperation(value = "Find All Single Page Article", response = ArticleDto.class)
    @GetMapping(ApiPaths.ArticleController.FIND_ALL_SINGLE_PAGE_ARTICLES)
    public ResponseEntity<List<ArticleDto>> findAllSinglePageArticle() throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.SINGLE_PAGE_ARTICLE).findAllSinglePage());
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

    @ApiOperation(value = "Delete Article", response = Boolean.class)
    @PostMapping(ApiPaths.ArticleController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).delete(id));
    }

    @ApiOperation(value = "Find By Url", response = ArticleDto.class)
    @GetMapping(ApiPaths.ArticleController.FIND_BY_URL + "/{url}")
    public ResponseEntity<ArticleDto> findByUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).findByUrl(url));
    }

    @ApiOperation(value = "Check Url", response = Boolean.class)
    @GetMapping(ApiPaths.ArticleController.CHECK_URL + "/{url}")
    public ResponseEntity<Boolean> checkUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).checkUrl(url));
    }
}
