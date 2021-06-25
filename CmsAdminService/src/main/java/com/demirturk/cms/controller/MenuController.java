package com.demirturk.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demirturk.cms.exception.CmsException;
import com.demirturk.cms.model.dto.ArticleDto;
import com.demirturk.cms.model.dto.MenuDto;
import com.demirturk.cms.service.MenuService;
import com.demirturk.cms.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.MenuController.CONTROLLER)
@Api(value = ApiPaths.MenuController.CONTROLLER)
public class MenuController {
    private final MenuService menuService;

    @ApiOperation(value = "Create Menu Item", response = ArticleDto.class)
    @PostMapping
    public ResponseEntity<MenuDto> create(@RequestBody MenuDto menuDto) throws CmsException {
        return ResponseEntity.ok(menuService.create(menuDto));
    }
}
