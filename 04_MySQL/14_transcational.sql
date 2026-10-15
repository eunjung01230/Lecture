create table accouts (
	id int primary key,
    owner varchar(50),
    balance decimal(10,2)
); 

insert into accouts(id, owner, balance)
values(1, '홍길동', 10000.00), (2, '김짱구', 5000.00);

-- 홍길동 계좌에서 김짱구 계좌로 3000원 이체 

-- 1. 홍길동 계좌 -3000
-- 문제발생!!
-- 2. 김짱구 계좌 +3000
-- 계좌이체는 논리적으로 하나의 작업이지만, 실제로는 동작하는 작업은 
-- 2번의 업데이트가 발생한다. 

-- transcation 이란?
-- 다수의 작업을 하나의 논리적인 작업 단위로 묶는 것을 의미한다. 
-- 따라서 다수의 작업 중 1개의 작업이라도 잘못되면 롤백 시키는 것이 
-- 핵심이다. 핵심이다. 핵심이다. 

-- start transaction 
-- commit 
-- rollback

-- 정상 계좌이체 흐름 

start transaction;

-- 홍길동 계좌 3000원 차감 
update accouts 
set balance = balance - 3000
where id = 1; 

-- 은행 정전 

-- 김짱구 계좌 3000원 차감 
update accouts 
set balance = balance + 3000
where id = 2; 

-- 중간 확인 / 주의 : 영구 반영된 상태는 아니다. 
select * from accouts; 

-- 모든 작업이 성공 반영 시작!
commit;

select * from accouts; 

-- 비정상 계좌이체 흐름 

start transaction;

-- 홍길동 계좌 3000원 차감 
update accouts 
set balance = balance - 3000
where id = 1; 

-- 중간 확인
select * from accouts; 

-- 없는 계좌 3000원 차감 
update accouts 
set balance = balance + 3000
where id = 99; 

-- 중간 확인 / 주의 : 영구 반영된 상태는 아니다. 
select * from accouts; 

-- 작업 중 일부가 문제 발생 했기 때문에 돌이키기 
rollback; -- **재밋다 이거 완전 중요 근데 하나가 잘못되면 전부 다시 돌이킴 start 이후에 실행된 것은 전부 롤백 / 커밋 전에 무조건 확인하기 

select * from accouts; 