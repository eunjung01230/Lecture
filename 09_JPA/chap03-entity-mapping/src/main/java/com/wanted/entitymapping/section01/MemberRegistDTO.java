package com.wanted.entitymapping.section01;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberRegistDTO {
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String phone;
    private String address;
    private LocalDateTime enrollDate;
    private MemberRole memberRole;
    private String status;

    public MemberRegistDTO(String memberPwd, String memberId, String memberName, String phone) {
        this.memberPwd = memberPwd;
        this.memberId = memberId;
        this.memberName = memberName;
        this.phone = phone;
    }
}
