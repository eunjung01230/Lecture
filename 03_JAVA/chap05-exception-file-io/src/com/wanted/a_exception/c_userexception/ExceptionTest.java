package com.wanted.a_exception.c_userexception;

import com.wanted.a_exception.c_userexception.exception.MoneyNagativeException;
import com.wanted.a_exception.c_userexception.exception.NotEnoughMoneyException;
import com.wanted.a_exception.c_userexception.exception.ProductPriceNegativeException;

public class ExceptionTest {
    //Exception을 상속받아 사용자지정을 만든 것은 throws은 필요 / RunE~ throws가 필수 아님 걍 각 throw만들어도됨
    public void checkMoney(int productPrice, int money) {
    // public void checkMoney(int productPrice , int money) throws ProductPriceNegativeException, MoneyNegativeException, NotEnoughMoneyException

        //상품 가격 음수일때?
        if(productPrice < 0) {
            throw new ProductPriceNegativeException(
                    "상품의 가격은 음수일 수 없습니다."
            );
        }

        //내가 가진 돈이 음수일때?
        if(money < 0) {
            throw new MoneyNagativeException(
                    "가진 돈이 음수일 수 없습니다"
            );
        }

        //상품 가격이 내가 가진 돈 보다 클 때?
        if(money < productPrice) {
            throw new NotEnoughMoneyException(
                    "가진 돈 보다 상품의 가격이 더 비싸요..."
            );
        }

        System.out.println("가진 돈이 충분합니다~~ 즐거운 쇼핑 하세요~~");
    }
}
