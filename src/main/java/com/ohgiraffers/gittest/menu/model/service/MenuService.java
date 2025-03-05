package com.ohgiraffers.gittest.menu.model.service;

import com.ohgiraffers.gittest.menu.model.dao.MenuMapper;
import com.ohgiraffers.gittest.menu.model.dto.CategoryDTO;
import com.ohgiraffers.gittest.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {

        this.menuMapper = menuMapper;
    }



    @Transactional
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }


}
