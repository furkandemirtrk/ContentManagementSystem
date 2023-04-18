package com.demirturk.cms.service.impl;

import com.demirturk.cms.model.dto.MenuDto;
import com.demirturk.cms.service.MenuService;
import com.demirturk.cmscommons.exception.CmsException;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public MenuDto create(MenuDto menuDto) throws CmsException {
        return null;
    }

    @Override
    public MenuDto update(MenuDto menuDto, Long id) throws CmsException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws CmsException {
        return false;
    }
}
