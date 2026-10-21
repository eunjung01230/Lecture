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

    public void printUpdateResult(int result, int price) {

        System.out.println("가격 업데이트!!");

        if (result > 0) {
            System.out.println("가격이 " + price + "원으로 변경되었습니다.");
        } else {
            System.out.println("가격 변경에 실패했습니다.");
        }
    }

//    public void printUpdateResult(int result) {
//        System.out.println("가격 업데이트!!");
//        MenuDTO[] updateMenuPrice = new MenuDTO[0];
//        for(MenuDTO menu : updateMenuPrice) {
//            int price = 0;
//            System.out.println(price);
//        }
//    }

    public void printDeleteResult(int deleteResult, int num) {
        int result = 0;
        if (result > 0) {
            System.out.println(
                    num + "번 메뉴가 삭제되었습니다."
            );
        } else {
            System.out.println(
                    num + "번 메뉴를 찾을 수 없습니다."
            );
        }
    }
}
