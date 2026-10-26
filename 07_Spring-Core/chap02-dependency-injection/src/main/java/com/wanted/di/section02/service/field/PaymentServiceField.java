package com.wanted.di.section02.service.field;

import com.wanted.di.section02.gateway.NaverPayGateway;
import com.wanted.di.section02.gateway.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* comment
    @Service 어노테이션은 @Component의
    특수한 형태이다.
    MVC 패턴 중 Service 계층에 해당하는 Bean에
    붙이게 된다.
 */

// 빈의 이름 지정 'feild'
@Service("field")
public class PaymentServiceField {

    /* comment
        @Autowired 어노테이션은 IoC 컨테이너에 있는 Bean을
        찾아서 사용하는 위치에 객체를 주입하겠다는 의미이다.
        객체와 객체를 결합 / 객체간의 의존성을 추가하는 것 짱 많이 씀
        ---
        필드 주입의 단점
        - final 키워드를 사용할 수 없다.
        - 필드에 직접 객체를 생성해도 대입해도 컴파일 에러가 발생하지 않는다. &어디?
     */
    @Autowired
    private PaymentInterface paymentInterface;
    //private final PaymentInterface paymentInterface; 반드시 초기화 해야함 근데 new 즉 생성자가 있어야함

    public boolean processPay(String orderId, int amount) {

        // paymentInterface = new NaverPayGateway(); 직접해도 오류는 안남 근데 권장되지 않음 막을 방법은 없어  &요기.

        System.out.println("결제 비즈니스 로직 시작! 주문 ID = " + orderId + ", 수량 = " + amount);

        boolean result = paymentInterface.processPay(orderId, amount);

        if(result) {
            System.out.println("결제 성공!");
        } else {
            System.out.println("결제 실패..");
        }
        return result;
    }
}