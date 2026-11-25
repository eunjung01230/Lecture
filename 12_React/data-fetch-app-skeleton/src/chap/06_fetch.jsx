/*
    화면이 나타날 때 데이터를 불러와 렌더링하기 (가장 많이 쓰는 패턴)
    테스트용 API: https://jsonplaceholder.typicode.com/users

    1. 데이터를 담을 state를 빈 값으로 만든다.      useState([])
    2. 마운트 시 한 번만 API를 호출한다.             useEffect(() => {...}, [])
    3. 응답이 오면 state에 저장한다. -> 리렌더링되며 목록이 그려진다.

    fetch(url)은 Promise를 반환하고, 응답 본문은 response.json()으로 한 번 더 변환한다. (이것도 Promise)
    await를 쓰려면 async 함수가 필요하다.
    useEffect의 콜백 자체는 async로 만들 수 없으므로(정리 함수만 반환할 수 있다) 안에 async 함수를 만들어 호출한다.

    의존성 배열을 빼면 state 변경 -> 리렌더링 -> effect 실행 -> 다시 요청... 이 무한 반복된다.
    (참고) 실무에서는 axios 라이브러리도 많이 쓴다. 응답 본문이 res.data에 객체로 들어 있다.
*/
import { useEffect, useState } from 'react';

function UserCard({user}) {
    return (
        <div style={{display: 'inline-block', width: 300, margin: 10, padding: 10, background: 'powderblue'}}>
            <h4>{user.name}</h4>
            <p>
                email: {user.email}<br/>
                phone: {user.phone}<br/>
                city: {user.address.city}
            </p>
        </div>
    );
}

function UserList() {

    const [users, setUsers] = useState([]);

    /*
        TODO 1: 마운트 시 한 번만 회원 목록을 요청하자.
                useEffect 안에 async function loadUsers() { ... } 를 만들고 바로 호출한다.
                const response = await fetch('https://jsonplaceholder.typicode.com/users');
                const json = await response.json();
                console.log(json)로 확인한 뒤 setUsers(json)
    */

    if (users.length === 0) return <h3>불러오는 중...</h3>;

    return (
        <div>
            {/* TODO 2: users.map으로 <UserCard key={...} user={...}/>를 출력하자. */}
        </div>
    );
}

export default function Fetch() {
    return (
        <>
            <h1>회원 목록</h1>
            <UserList/>
        </>
    );
}
