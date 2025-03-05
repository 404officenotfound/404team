package com.ohgiraffers.gittest.menu.controller;

import com.ohgiraffers.gittest.menu.model.dto.CategoryDTO;
import com.ohgiraffers.gittest.menu.model.dto.MenuDTO;
import com.ohgiraffers.gittest.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {

        this.menuService = menuService;
        this.messageSource = messageSource;

    }

    // --------------- insert
    @GetMapping("regist")
    public void registPage() {}

    @GetMapping(value="category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        System.out.println("JavaScript 내장 함수인 fetch 비동기 함수 도착!");
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rAttr, Locale locale) {

        menuService.registNewMenu(newMenu);

        logger.info("Locale : {}", locale);

//        rAttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공하셨습니다.");
        rAttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));

        return "redirect:/menu/list";
    }


}