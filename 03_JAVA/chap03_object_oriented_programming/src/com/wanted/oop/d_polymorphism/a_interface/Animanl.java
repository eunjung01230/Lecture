package com.wanted.oop.d_polymorphism.a_interface;

import java.net.PortUnreachableException;

public interface Animanl {

    /* comment. Interface
        인터페이스란,
        Can - Do
        해당 인터페이스를 상속받는 클래스들이
        해야되는 기능(Can - Do)을 강제한다.
     */

    //인터페이스는 생성자를 사용하지 못한다.
    // public Animanl() {}
    // 인터페이스는 구현부가 있는 메소드를 못 쓴다.
    // public void test() {}

    void run();

    void eat();

    void bark();
}
