package com.wante.restaurant.menu.controller;

import com.wante.restaurant.menu.model.dto.MenuDTO;
import com.wante.restaurant.menu.model.service.MenuService;

import java.util.List;

public class MenuController {

    /* comment.
        Controller 계층의 책임
        - View와 Service 사이를 연결하는 커멘트센터
        - View에서 사용자의 입력 값을 토대로 Controller에게
        전달을 하게 되면 Controller는 적절한 Service를 호출한다.
        Controller가 해야할 일
        - 1. View 에서 전달 받은 요청을 처리하는 메서드(findAllMenus)
        - 2. 적절한 Service 메서드 호출 코드
        - 3. 필요하다면 DTO로 값 조립, 간단한 유효성 처리
        Controller가 하면 안되는 일
        - 1. Scanner 입력 처리 -> view의 일
        - 2. 비즈니스 관련 로직
        - 3. SQL 관련 작업
     */

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // public void findAllMenus() + return 필요없음
    public List<MenuDTO> findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        return menuList;
    }
}
