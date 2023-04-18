package com.demirturk.cmscontentservice.controller;

import com.demirturk.cmscontentservice.util.ApiPaths;
import com.demirturk.cmscontentservice.factory.ArticleServiceFactory;
import com.demirturk.cmscontentservice.model.dto.ArticleDto;
import com.demirturk.cmscontentservice.model.request.FindAllArticleByArticleTemplateUrlRequest;
import com.demirturk.cmscommons.enums.ArticleType;
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
@RequestMapping(ApiPaths.ArticleController.CONTROLLER)
public class ArticleController {

    private final ArticleServiceFactory articleServiceFactory;

    @PostMapping(ApiPaths.ArticleController.FIND_ALL_BY_ARTICLE_TEMPLATE)
    public ResponseEntity<List<ArticleDto>> findAllMultiPageArticleByArticleTemplateUrl(
            @RequestBody FindAllArticleByArticleTemplateUrlRequest findAllArticleByArticleTemplateUrlRequest)
            throws CmsException {
        return ResponseEntity.ok(
                articleServiceFactory.getArticleService(ArticleType.Values.MULTI_PAGE_ARTICLE)
                        .findAllByArticleTemplate(findAllArticleByArticleTemplateUrlRequest.getUrl()));
    }

    @GetMapping(ApiPaths.ArticleController.FIND_ALL_SINGLE_PAGE_ARTICLES)
    public ResponseEntity<List<ArticleDto>> findAllSinglePageArticle() throws CmsException {
        return ResponseEntity.ok(articleServiceFactory
                .getArticleService(ArticleType.Values.SINGLE_PAGE_ARTICLE).findAllSinglePage());
    }

    @PostMapping
    public ResponseEntity<ArticleDto> create(@RequestBody ArticleDto articleDto) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory
                .getArticleService(articleDto.getArticleType().name()).create(articleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> update(@RequestBody ArticleDto articleDto,
                                             @PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory
                .getArticleService(articleDto.getArticleType().name()).update(articleDto, id));
    }

    @PostMapping(ApiPaths.ArticleController.DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).delete(id));
    }

    @GetMapping(ApiPaths.ArticleController.FIND_BY_URL + "/{url}")
    public ResponseEntity<ArticleDto> findByUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).findByUrl(url));
    }

    @GetMapping(ApiPaths.ArticleController.CHECK_URL + "/{url}")
    public ResponseEntity<Boolean> checkUrl(@PathVariable String url) throws CmsException {
        return ResponseEntity.ok(articleServiceFactory.getArticleService(ArticleType.Values.ARTICLE).checkUrl(url));
    }
}
