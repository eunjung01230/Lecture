-- DML(Data Manipulation Language)
-- 데이터 조작 언어 
-- INSERT, UPDATE, DELETE 추가 수정 삭제 

select * from users;
desc users;

-- insert into 테이블명 (컬럼명...) values(넣을 값...)  ...= 여러개가 들어갈 수 있음 
insert into users (`email`, `name`) 
values ('email@gmail.com', '조평훈');   -- 한개의 행이 추가됨 (id값이 자동으로 추가됨 desc때문)

-- 에러 케이스 확인
-- 데이터를 삽입할 때 Error가 무지막지하게 많이 발생한다. 
-- * !! 이럴때 확인해야 하는 건 테이블의 제약조건과, 데이터 타입!!*
--  unique 제약조건 위반: 중복 이메일 불허 
insert into users (`email`, `name`) 
values ('email@gmail.com', '조평순'); -- 이메일 컬럼은 유니크인데 중복이 발생해서 오류
-- not null 제약조건 위반 : name 컬럼은 반드시 데이터 삽입 시 데이터가 존재해야 한다. 
insert into users (`email`) 
values ('email2@gmail.com'); -- name이라는 컬럼은 기본값(not null설정있음)을 가져야 하는데 비어있음 / desc users; 실행으로 조건 확인 (null - no) 

-- 예외 케이스 확인 
-- 정수값을 입력하더라도 DB가 ' '를 붙여 문자열로 자동 형변환을 해서 insert 해버린다
-- 예외에 대한 처리를 DB에서 하는 것이 아닌 front, back 족에서 정재해야 한다.  
insert into users (`email`,`name`) 
values ('email2@gmail.com', 123);  -- 123오류 안뜸 알아서 정수를 ' '를 붙여 문자열로 바꿔줌 데이터가 데이터베이스로 넘어오기전 백엔드에서 문제를 해결해야함 

-- ***외래키 참조 무결성 위반 **********
insert into courses (`author_id`, `title`, `description`) 
values (1, 'SQL 제약조건', '제약조건을 확인해봐요');
-- users 테이블에 존재하지 않는 999회원을 author_id 에 집어넣으려고 하고 있음
-- 때문에 외래키 참조 무결성 조건에 위반한다. 
-- 고아데이터를 방지하는 역할을 하게 된다. + 데이터를 넣을 때(존재시킬 때) 즉, 생성은 부모 먼저, 자식 나중 + 삭제는 자식 먼저, 부모 나중 
insert into courses (`author_id`, `title`, `description`) 
values (999, 'SQL 제약조건', '제약조건을 확인해봐요'); -- 자식행을 추가할 수 없음 외래키의 제약조건을 위반함 | 123번 회원까지만 있는데 값자기 999? 부모값에 없는 고아값을 insert불가 



-- Update
-- update 테이블명 set 컬럼명 = 수정할 값
-- 수정, 삭제 작업에서 가장 필수적으로 생각해야 하는 것은 
-- where 조건절!!!
-- where 조건절에는 1개의 행을 식별할 수 있는 유일한 값으로 
-- 조건을 거는 것이 권장된다. (pk, unique) 
update users set `name` = '조평훈'; -- update 할때 조건절 설정 안하면 개망 이거 실행하면 데이터의 모든 이름이 조평훈으로 바뀜 

update users set `name` = '조평순' where `user_id` = 1 ;

select * from users;



-- Delete
-- delete from 테이블명 
delete from users where email = 'email@gmail.com'; -- delete 할때 조건절 설정 안하면 개망 이거 실행하면 데이터의 모든 이메일 삭제 

-- 에러케이스 
-- user_id 컬럼은 courses 테이블에 author_id 컬럼으로 
-- fk(외래키)로 주고 있다. 
-- fk 받는 테이블 (자식 테이블) / fk 주는 테이블(부모 테이블) 
-- 부모 테이블에 값을 삭제하면 자식 테이블의 데이터가 (고아데이터)가 됨 
-- 때문에 삭제가 거부된다. *생성은 부모 먼저, 자식 나중 *삭제는 자식 먼저, 부모 나중 (예외로 외래키 컬럼이 NULL을 허용하는 경우 단, NULL 허용 = 고아데이터 허용 아님) 
-- 단, FK 컬럼이 NULL 허용이면 부모를 참조하지 않는 상태는 가능 -> 이것은 “고아데이터 허용”이라기보다 “참조 없음” 상태
delete from users where user_id = 1;  

select * from courses;

