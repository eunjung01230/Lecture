package com.wanted.oop.d_polymorphism.a_interface;

//인터페이스를 상속 받을 때는
//extends가 아닌 implements로 하게 된다. + Alr Enter 후 메서드를 생성해야 한다. 강제성이 부여되었기 때문
public class Raccoon implements Animanl{
    @Override
    public void run() {
        System.out.println("너구리가 폴짝폴짝 뛰어댕깁니다..");
    }

    @Override
    public void eat() {

    }

    @Override
    public void bark() {

    }
}
