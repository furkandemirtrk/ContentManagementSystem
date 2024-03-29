package com.demirturk.cms.service;

import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

import com.demirturk.cms.model.dto.MenuDto;

@Service
public interface MenuService {
    MenuDto create(MenuDto menuDto) throws CmsException;
    MenuDto update(MenuDto menuDto, Long id) throws CmsException;
    boolean delete(Long id) throws CmsException;
}
