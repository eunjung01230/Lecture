package com.wanted.a_generic.b_use;

/*comment.
    해당 클래스는 토끼들의 농장이며
    Rabbit, Bunny, DrunkenBunny 어떤 토끼가
    들어올지 몰라 제네릭으로 생성
    T -> 타입변수에는 어떤 값이 들어올지 모르는 상태이다.
    그래서 포유류, 파충류, 뱀 등이 전부 들어올 수 있다.
    T extednds Rabbit을 지정하면
    Rabbit 또는 Rabbit 을 상속받는 클래스만 T에
    들어올 수 있게 된다.
 */
public class RabbitFarm<T extends Rabbit>{

    private T animal;

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    //기본생성자
    public RabbitFarm() {}

    //매개변수가 있는 생성자

    public RabbitFarm(T animal) {
        this.animal = animal;
    }
}
