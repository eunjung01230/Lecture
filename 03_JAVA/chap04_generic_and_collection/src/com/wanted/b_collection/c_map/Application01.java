package com.wanted.b_collection.c_map;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Application01 {
    public static void main(String[] args) {

        /* comment. Map
            Map 특징
            1. Key-Value : 키-값 한 쌍으로 데이터를 저장한다.
            2. Key는 내부적으로 Set 방식으로 구성이 되어있다.(중복이 허용이 안됨.유일)
         */

        //Map은 인터페이스이다.
        // 따라서 객체를 생성할 때 Map 인터페이스를
        // 상속받은 클래스로 객체를 생성해야 한다.
        Map map = new HashMap(); //여러가지 타입가능(다형성)

        map.put("one" , new Date());
        map.put(12, "apple");
        //key는 중복되게 되면 나중에 작성한 값으로 덮여씌워지게 된다.
        map.put(12, "banana");

        System.out.println("map = " + map);

        // banana
        System.out.println("banana 값 출력하기 : " + map.get(12));

        Map<String, String> map2 = new HashMap<>();
        //Map의 Key 값은 암묵적으로
        //String 타입으로 하는 것이 일반적이다.
        map2.put("one", "java");
        map2.put("two", "javascript");
        map2.put("three", "python");

        System.out.println("map2 = " + map2);
        map2.remove("three");
        System.out.println("map2 = " + map2);
    }
}

