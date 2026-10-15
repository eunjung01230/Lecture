package com.wanted.b_fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application01 {
    public static void main(String[] args) {

        //파일 쓰기
        try {
            //File IO(입출력) 관련 클래스들은 객체 생성 시 예외를 반드시 처리하게 설정이 되어 있다.
            FileWriter writer = new FileWriter("output.txt"); // 기본생성자가 없어서 생성인자가 꼭 필요함 매개변수로만 이루어짐
            writer.write("Hello, File IO!");
            writer.write("File Test");

            //버퍼(연결통로)에 있는 데이터를
            //밀어서 디스크에 저장한다.
            writer.flush(); //밀어버린다 push같은? -> 남아 있는 데이터를 파일 쪽으로 밀어낸다.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //파일 읽기 작업
        try {
            FileReader reader = new FileReader("output.txt");

            int data;
            //read() : 파일에서 한 문자씩 읽고, 파일 끝에 도달하면 -1을 반환
            while ((data = reader.read()) != -1) {
                System.out.println((char) data);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
