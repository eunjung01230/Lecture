package com.wanted.project.domain.menu.controller;

import com.wanted.project.domain.menu.model.dto.CategoryDTO;
import com.wanted.project.domain.menu.model.dto.MenuDTO;
import com.wanted.project.domain.menu.model.service.MenuService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 * [MenuController]
 * 역할 : /menu/** 요청을 받아 MenuService 를 호출하고, 결과를 화면(View) 이나 JSON 으로 돌려준다.
 * 책임 : - 요청 파라미터를 받고, 입력값 검증(@Valid, @NotBlank 등)을 "선언" 한다.
 *        - 어떤 화면으로 보낼지(View 이름, redirect) 결정한다.
 *        - 비즈니스 로직, 트랜잭션, Entity 는 다루지 않는다. (Service 의 책임, Controller 는 DTO 만 사용)
 *        - try-catch 를 쓰지 않는다. 예외는 GlobalExceptionHandler 가 처리한다.
 *
 * 할 일
 *  1. findByMenuByPathVariable() : 메뉴 1건 조회 -> "result" 로 담아 menu/detail
 *  2. findMenuList()             : 전체 메뉴 조회 -> "menuList" 로 담아 menu/list
 *  3. findByMenuPrice()          : 가격 초과 메뉴 조회 -> "menuList", "price" 로 담아 menu/searchResult
 *                                  (검증 : menuPrice 는 0 이상 -> @Min)
 *  4. findCategoryList()         : 하위 카테고리 목록을 JSON 으로 반환 (regist.html 의 fetch 가 호출)
 *  5. registMenu()               : 메뉴 등록 -> 등록된 메뉴 상세(/menu/{menuCode}) 로 redirect
 *                                  (검증 : 파라미터에 @Valid 를 붙여 MenuDTO 의 검증 규칙 적용)
 *  6. modifyMenuName()           : 메뉴 이름 수정 -> 수정된 메뉴 상세(/menu/{menuCode}) 로 redirect
 *                                  (검증 : menuName 은 필수, 30자 이하 -> @NotBlank, @Size)
 *  7. deleteMenu()               : 메뉴 삭제 -> 전체 메뉴 목록(/menu/list) 으로 redirect
 *  8. [PART 3] stopSelling() / resumeSelling() : 판매중지 / 판매재개 (메뉴 상세 화면의 버튼)
 *                                  -> 해당 메뉴 상세(/menu/{menuCode}) 로 redirect
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/menu/*")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public ModelAndView findByMenuByPathVariable(@PathVariable int menuCode, ModelAndView mv) {
        // TODO 1
        return null;
    }

    @GetMapping("/list")
    public ModelAndView findMenuList(ModelAndView mv) {
        // TODO 2
        return null;
    }

    @GetMapping("/querymethod")
    public void queryPage() {}

    @GetMapping("/search")
    public ModelAndView findByMenuPrice(@RequestParam int menuPrice, ModelAndView mv) {
        // TODO 3
        return null;
    }

    @GetMapping("/regist")
    public String regist() {
        return "menu/regist";
    }

    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        // TODO 4
        return null;
    }

    @PostMapping("/regist")
    public ModelAndView registMenu(@ModelAttribute MenuDTO registMenu, ModelAndView mv) {
        // TODO 5
        return null;
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public ModelAndView modifyMenuName(@RequestParam int menuCode, @RequestParam String menuName, ModelAndView mv) {
        // TODO 6
        return null;
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public ModelAndView deleteMenu(@RequestParam int menuCode, ModelAndView mv) {
        // TODO 7
        return null;
    }

    @PostMapping("/stop")
    public ModelAndView stopSelling(@RequestParam int menuCode, ModelAndView mv) {
        // TODO 8
        return null;
    }

    @PostMapping("/resume")
    public ModelAndView resumeSelling(@RequestParam int menuCode, ModelAndView mv) {
        // TODO 8
        return null;
    }
}
