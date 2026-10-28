package com.wanted.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* comment.
    Spring Boot App은 Tomcat이 내장되어 있다.
    지금까지 사용자의 요청이 있으면 요청을 처리 할
    Servlet을 만들었다고 한다면,
    Servlet은 Http 요청을 받는 즉시 @Controller
    어노테이션이 달린 클래스에 요청을 위임한다.
 */
@Controller
public class MethodController {

    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        /* comment. model 객체
            백엔드 서버에서 발생한 값을 담을 수 있는
            Request 객체이다. key-value 형태로 값을
            담을 수 있다.
         */
        System.out.println("동작하니?");

        model.addAttribute("message", "GET 방식의 메뉴 등록 핸들러 메서드 동작함:)");

        /* comment.
            @Controller 계층의 마지막 임무는
            사용자에게 어떤 응답을 해줄 것인지를 결정하는 것이다.
            메소드의 반환타입을 String으로 한 후 , 문자열을
            return하면 resources/templates 가 자동으로 접두사,
            .html이 접미사로 설정된다. : 포워드 방식 책임전가?
            Servlet -> forward(req, res)
         */
        return "mappingResult";
    }

    //@RequestMapping : Servlet에서 sevice()라는 메소드와 같은 역할: get/post/delete 다 받을 수 있음
    @RequestMapping(value = "/menu/regist", method = RequestMethod.POST)
    public String postregistMenu(Model model) {

        model.addAttribute("message", "POST 방식의 메뉴 등록 핸들러 메서드 동작함:)");

        return "mappingResult";
    }

    @GetMapping("/menu/modify")
    public String getModifyMenu(Model model) {

        model.addAttribute("message", "Get 방식의 메뉴 수정 핸들러 메서드 동작함:)");

        return "mappingResult";
    }

    @PostMapping("/menu/modify")
    public String postModifyMenu(Model model) {

        model.addAttribute("message", "POST 방식의 메뉴 수정 핸들러 메서드 동작함:)");

        return "mappingResult";
    }
}
