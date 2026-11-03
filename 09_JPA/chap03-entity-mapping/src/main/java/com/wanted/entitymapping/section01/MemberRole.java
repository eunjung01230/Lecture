package com.wanted.entitymapping.section01;

/* comment. enum(열거형)
    enum 타입은 시스템 정책 상 정해져 있는 값
    즉, 제한 된 값만 사용하기 위해 강제화 할 수 있는 역할의 클래스이다.
    ex) 성별, 권한 등등 정해져 있는 값
    한 곳에 모오두기 위해 많이 씀 / 변하지 않는 제한된 값들
 */
public enum MemberRole {
    // 우리 프로젝트에서 회원의 권한은 2개로 고정
    // 접근제한자 없이 필드만 작성함
    ROLE_MEMBER, ROLE_ADMIN
}
