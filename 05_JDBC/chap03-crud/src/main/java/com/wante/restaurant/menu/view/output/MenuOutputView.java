package com.wante.restaurant.menu.view.output;

import com.wante.restaurant.menu.model.dto.MenuDTO;

import javax.sound.midi.Soundbank;
import java.util.List;

public class MenuOutputView {

    public void printMenus(List<MenuDTO> menuList) {

        System.out.println("메뉴 전체 조회 리스트!!");
        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }
}
