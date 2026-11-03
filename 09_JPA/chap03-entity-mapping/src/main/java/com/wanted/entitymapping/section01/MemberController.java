package com.wanted.entitymapping.section01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberSercive memberSercive;

    //Controller에서 Service Bean을 주입(의존)
    @Autowired
    public MemberController(MemberSercive memberSercive) {
        this.memberSercive = memberSercive;
    }

    public void registMember(MemberRegistDTO memberRegistDTO) {

        int memberNo = memberSercive.registMember(memberRegistDTO);
    }

    public void findMember(int memberNo) {
        MemberRegistDTO foundMember = memberSercive.findByMemberNo(memberNo);
        System.out.println("foundMember = " + foundMember);

    }
}
