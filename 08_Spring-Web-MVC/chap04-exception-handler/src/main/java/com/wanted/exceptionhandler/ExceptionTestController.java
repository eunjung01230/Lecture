package com.wanted.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class ExceptionTestController {

    @GetMapping("nullpointer")
    public String nullpointer() {

        //고의적으로 Error 발생
        String str = null;
        System.out.println(str.toLowerCase(Locale.ROOT));

        return "/";
    }
}
