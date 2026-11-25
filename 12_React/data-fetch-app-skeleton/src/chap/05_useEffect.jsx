/*
    useEffect
    컴포넌트가 화면에 그려진 "이후"에 실행할 작업을 등록한다. (데이터 요청, 타이머 시작 등)

    useEffect(() => { 실행할 코드 }, [의존성 배열]);

    1. 의존성 배열 생략   : 렌더링 될 때마다 실행
    2. 빈 배열 []         : 처음 화면에 나타날 때(마운트) 한 번만 실행
    3. [값1, 값2]         : 마운트 + 배열 안의 값이 바뀌었을 때만 실행

    정리(clean-up) 함수
    effect에서 함수를 return 하면, 컴포넌트가 사라질 때(언마운트) 또는 effect가 다시 실행되기 직전에 실행된다.
    타이머처럼 effect에서 시작한 작업은 정리 함수에서 종료해야 한다. (안 하면 계속 동작한다)
*/
import { useState, useEffect } from 'react';

function EffectTest() {

    const [count, setCount] = useState(0);
    const [text, setText] = useState('');

    /*
        TODO 1: 의존성 배열 없이 useEffect를 작성하자.   -> 렌더링 될 때마다 실행
        TODO 2: 빈 배열 []로 작성하자.                    -> 마운트 시 한 번만 실행
        TODO 3: [count]로 작성하자.                       -> count가 바뀔 때만 실행 (입력할 때는 실행 안 됨)
        각각 console.log를 넣고 버튼 클릭 / 입력하며 콘솔을 비교하자.
    */

    return (
        <>
            <h2>count: {count}</h2>
            <button onClick={() => setCount(count + 1)}>+ 1</button>
            <br/>
            <input value={text} onChange={e => setText(e.target.value)} placeholder="입력해서 콘솔 확인"/>
        </>
    );
}

function Timer() {

    const [time, setTime] = useState(() => new Date().toLocaleTimeString());    // 처음 한 번만 계산

    /*
        TODO 4: 마운트 시 setInterval로 1초마다 setTime(new Date().toLocaleTimeString())을 호출하자.
                -> h2의 시간이 1초마다 바뀐다.
                interval 안에 console.log('tick')도 넣어 두자. (숨긴 뒤에도 타이머가 도는지 확인용)
                정리 함수(return () => {...})에서 clearInterval로 타이머를 멈추자.
                -> 정리 함수 없이 먼저 토글해 보고, 숨긴 뒤에도 tick이 계속 찍히는 것을 확인하자.
    */

    return <h2>현재 시간: {time}</h2>;
}

export default function Effect() {
    const [isShow, setIsShow] = useState(false);

    return (
        <>
            <h1>의존성 배열</h1>
            <EffectTest/>
            <hr/>
            <h1>정리 함수</h1>
            <button onClick={() => setIsShow(!isShow)}>타이머 토글</button>
            {isShow && <Timer/>}
        </>
    );
}
