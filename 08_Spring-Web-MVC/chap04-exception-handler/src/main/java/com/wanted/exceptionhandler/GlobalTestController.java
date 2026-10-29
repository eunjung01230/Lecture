package com.wanted.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class GlobalTestController {

    /* comment.
        ExceptionTestController에서 작성해둔
        null-pointer 예외처리 핸들러가 동작하지 않는다.
        이유: 다른 클래스 내부에 있는 메서드는 알 수 없다.

     */
    @GetMapping("global-nullpointer")
    public String globalNull() {
        String str = null;
        System.out.println(str.toLowerCase(Locale.ROOT));

        return "/";
    }
}
