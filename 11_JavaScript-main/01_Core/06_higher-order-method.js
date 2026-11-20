/*
    고차함수란?
    함수를 인자로 전달 받거나, 함수를 반환하는 함수
    배열의 고차 함수는 콜백 함수를 인자로 받아
    배열의 요소를 순회하며 처리하게 된다.
*/

const menus = [
    { name: '치즈 떡볶이' , category : '분식' , price : 14000 },
    { name: '순대' , category : '분식' , price : 3000 },
    { name: '파스타' , category : '양식' , price : 19000 },
    { name: '제육볶음' , category : '한식' , price : 10000 },
    { name: '김치찜' , category : '한식' , price : 8000 }
];

// forEach : 배열의 각 요소마다 콜백 함수를 실행(반환값 없음)
console.log("================forEach==================")
// forEach 함수는 배열의 요소 하나를 인자로 전달 받아 동작시킬
// 코드를 실행한다.
menus.forEach( menu => console.log(menu) );

console.log("================map==================")
// map : 콜백 함수의 반환 값으로 새로운 배열을 return
const names = menus.map( menu => menu.name );
console.log(names);

console.log("================filter==================")
// filter : 콜백 함수의 반환값이 true 인 요소만 모아 새로운 배열 return
// 5개의 메뉴 중 , 분식만 모아서 출력
// === , == 
// == : 동등 비교 (암묵적으로 타입 변환을 통해 같은 값인지 비교)
// === : 일치 비교 (타입과 값이 모두 일치)
console.log(` 1 == '1' : ${1 == '1'}`);
console.log(` 1 === '1' : ${1 === '1'}`);


const snacks = menus.filter( menu => menu.category === '분식' );
// 가격이 10000원 미만인 메뉴들만 필터링
const menu = menus.filter( menu => menu.price < 10000 );
console.log(snacks);
console.log(menu);

// filter , map 조합
// 분식 중에서 가격이 1만원 미만인 메뉴의 이름 목록

const result = menus
                // 첫번째 필터를 마무리 하면
                // 분식들만 모인 메뉴 배열이 된다.
                .filter(menu => menu.category === '분식') 
                // 두번째 필터를 마무리 하면
                // 10000원 미만 분식이 모인 메뉴 배열이 된다.
                .filter(menu => menu.price < 10000)
                // 배열 요소를 순회하며
                // 메뉴 이름 return 해서 배열을 만든다.
                .map(menu => menu.name)

console.log(result);