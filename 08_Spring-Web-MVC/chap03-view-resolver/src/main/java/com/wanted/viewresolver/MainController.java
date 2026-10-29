package com.wanted.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // {} 내부에는 여러 경로를  , 기준으로 작성할 수 있다.
    @RequestMapping(value = {"/", "/main"})
    private  String mainPage() {
        System.out.println("mainPage 핸들러메서드 동작함 :(");
        return "main";
    }
}
