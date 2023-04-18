package com.demirturk.cmscontentservice.service;

import com.demirturk.cmscontentservice.model.dto.CategoryTemplateDto;
import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryTemplateService {

    List<CategoryTemplateDto> getAll() throws CmsException;

    CategoryTemplateDto create(CategoryTemplateDto categoryTemplateDto) throws CmsException;

    CategoryTemplateDto update(CategoryTemplateDto categoryTemplateDto, Long id) throws CmsException;

    boolean delete(Long id) throws CmsException;

    boolean checkUrl(String url) throws CmsException;

    List<CategoryTemplateDto> findAllByArticleTemplateNotChoose() throws CmsException;

    CategoryTemplateDto findByUrl(String url) throws CmsException;
}
