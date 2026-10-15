-- 각 쿼리문의 결과를 합치는 union 
-- 수학의 합집합, 중복된 행은 제거하여 순수한 합집합을 만든다. 

-- users 테이블에 active 사용자와, suspended 사용자 
-- 모두에게 이메일을 발송하고자 한다. 
-- 탈퇴한 deleted 유저는 제외한다. 
-- 사용자의 이름, 이메일, 상태를 조회해라

-- union 은 각각의 쿼리문의 결과를 합치는 역할을 하게 된다. 
-- 단, 합칠때는 조회하려는 컬럼 갯수가 동일해야 한다. 
-- 단, 컬럼 순서와 데이터 타입이 호환이 가능해야 한다. 

select 
	`name`, 
    `email`,
    `status`
from 
	users
where 
	status = 'active'  -- where status = 'active'; -> where status = 'active' union 즉, ;해서 부닐되어 있던 것을 ; 없애고 union 넣어서 합침 
    -- UNION : 여러 SELECT문의 결과를 하나로 합침 각 SELECT 사이의 ;는 제거하고 UNION으로 연결 UNION은 중복 행을 제거함
	-- 실무에서는 상황에 따라 사용하지만 JOIN보다 사용 빈도는 낮은 편 왜? 컬럼 갯수, 순서 다 똑같아야지 오류 안남 
union
select 
	`name`, 
    `email`,
    `status`
from 
	users
where 
	status = 'suspended';