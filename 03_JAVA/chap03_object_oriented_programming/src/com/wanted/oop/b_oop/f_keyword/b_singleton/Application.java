package com.wanted.oop.b_oop.f_keyword.b_singleton;

import java.util.concurrent.atomic.LongAccumulator;

public class Application {
    public static void main(String[] args) {

        /* comment. static 키워드를 활용한 singleton 패턴
            싱글톤 -> 단일 인스턴스
            어플리케이션이 실행될 때 어떤 클래스가
            최초 한 번만 메모리에 할당되고, 그 메모리에
            인스턴스를 만들어서 하나의 인스턴스를 공유해 사용하여
            메모리 낭비ㅣ를 방지할 수 있게 하는 디자인 패턴을 의미
            - 리모콘 -> 1개
         */

        /* comment. 싱글톤 패턴은 2가지 방법이 있다.
            1. 이른 초기화 (Eager) /런 할때 전부 생성하고 시작이라 로딩이 걸림 단 이미 채워져 있으니 호출은 바로바로
            2. 게으른 초기화 (Lazy) /런 할때 생성없어서 시작이 빠름 대신 각 호출시 생성을 해서 딜레이 생길 수 있음
         */

        // 인스턴스를 생성하는 기본생성자를 private로 막았기 때문에
        // 외부 클래스에서는 new로 객체를 만들 수 없게 만들어 둠 (new를 못 쓰게 리모컨 또 못 만듦)
        // EagerSingleton eager1 = new EagerSingleton();


        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();

        System.out.println("eager1의 hashcode() : " + eager1.hashCode());
        System.out.println("eager2의 hashcode() : " + eager2.hashCode());

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        System.out.println("lazy1의 hashcode() : " + lazy1.hashCode());
        System.out.println("lazy2의 hashcode() : " + lazy2.hashCode());

    }
}
