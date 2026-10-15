package com.wanted.oop.d_polymorphism;

public class Koala extends Animanl {
    @Override
    public void eat() {
        System.out.println("코알라가 유칼리투스 잎을 먹습니다...");
    }

    @Override
    public void run() {
        System.out.println("코알라가 다른 나무로 폴~짝 뜁니다...");
    }

    @Override
    public void bark() {
        System.out.println("코알코알");
    }

    public void sleep() {
        System.out.println("코알라는 하루에 20시간을 잡니다...zzzzzzzz");
    }
}
