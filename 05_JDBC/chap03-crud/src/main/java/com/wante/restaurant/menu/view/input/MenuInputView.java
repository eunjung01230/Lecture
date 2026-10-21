package com.wante.restaurant.menu.view.input;

import com.wante.restaurant.menu.controller.MenuController;
import com.wante.restaurant.menu.model.dto.MenuDTO;
import com.wante.restaurant.menu.view.output.MenuOutputView;

import java.util.List;
import java.util.Scanner;

public class MenuInputView {

    /* comment.
        View 패키지의 책임
        - View 사용자와 상호작용을 하는 책임을 갖는다.
        - InputView의 할 일
        - 사용자가 입력할 수 있는 환경을 제공한다.
        - 1. Scanner 객체 사용
        - 2. Controller에게 사용자 입력 값 제공
        - 3. OutputView를 호출하여 결과 출력 요청
        - InputView 가 하면 안 되는 일
        - 1. SQL 작성
        - 2. 비즈니스 로직 처리(ex 요리하기 등 )
        - 3. commit / rollback
     */

    private final MenuController menuController;
    private final MenuOutputView menuOutputView;
    private final Scanner sc = new Scanner(System.in);

    // 생성자를 통한 필드 초기화
    public MenuInputView(MenuController menuController, MenuOutputView menuOutputView) {
        this.menuController = menuController;
        this.menuOutputView = menuOutputView;
    }

    public void displayMainView() {

        System.out.println("실습 TEST");
        System.out.println("1. 메뉴 전체 조회");
        System.out.println("2. 메뉴 가격 업데이트");
        System.out.println("3. 메뉴 삭제");
        System.out.println("원하는 서비스를 선택하세요");

        int no = sc.nextInt();

        switch (no) {
            case 1:
                //menuController.findAllMenus();
                System.out.print("메뉴를 입력해주세요 : ");
                String menu = sc.nextLine();
                List<MenuDTO> menuList = menuController.findAllMenus();
                menuOutputView.printMenus(menuList);
                break;

            case 2:
                System.out.print("메뉴 코드를 입력해주세요 : ");
                int code = sc.nextInt();

                System.out.print("원하는 변경 가격을 입력해주세요 : ");
                int price = sc.nextInt();

                int result = menuController.updateMenuPrice(code, price);

                menuOutputView.printUpdateResult(result, price);

                break;
//                System.out.print("메뉴 코드를 입력해주세요 : ");
//                int code = sc.nextInt();
//                System.out.print("원하는 변경 가격을 입력해주세요 : ");
//                int price = sc.nextInt();
//                int result = menuController.updateMenuPrice(code, price);
//                if (result > 0) {
//                System.out.println("가격이 " + price + "원으로 변경되었습니다.");
//            } else {
//                System.out.println("가격 변경에 실패했습니다.");
//            }
//            break;
//
//            default:
//                System.out.println("잘못된 번호입니다.");

            case 3:
                System.out.print("메뉴 코드를 입력해주세요 : ");
                int num = sc.nextInt();
                int deleteResult = menuController.deleteMenu(num);
                menuOutputView.printDeleteResult(deleteResult, num);
                List<MenuDTO> updatedMenuList = menuController.findAllMenus();
                menuOutputView.printMenus(updatedMenuList);

                break;

        }

    }
}