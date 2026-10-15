-- 여기서부터 12,13,14는 성능 개선에서 장점을 가진 기능들 

-- View 란?
-- 가상의 테이블

-- [시나리오]
-- LMS 데이터 분석팀은 '과정별 등록 학생 수' 통계를 매일 확인한다.
-- 이 통계를 얻기 위해서는 enrollments 테이블을 조회하는 쿼리를
-- 작성한다.
-- LMS 마케팅 팀에게는 데이터분석 팀이 사용자의 전체 정보를
-- 오픈하지 않고, 실제로 사용 될 정보인 이메일/이름만 전달하고자
-- 한다.

-- View 를 사용하는 이유
-- 편의성 : 복잡한 쿼리를 뷰로 만들게 되면, 이후에는 마치
-- 하나의 간단한 테이블처럼 쉽게 데이터를 조회할 수 있다.
-- + 원본 문서를 직접 안 보여주고, 필요한 내용만 보여주는 공유용 문서

-- 보안성 : 원본 테이블의 민감한 정보를 숨기고, 허용 된 컬럼으로만 
-- 구성 된 view(가상테이블)을 제공함으로서 테이블 접근을 숨길 수 있다. 
-- + 즉, 모든 컬럼을 공개하지 않고 필요한 데이터만 가상 테이블 형태로 제공 (다양한 팀과 협업 시 좋음)  

-- 가독성 & 속도: 
-- 사용 빈도가 높은 컬럼들로만 구성을 할 수 있기 때문에
-- 가독성이 높으며, 조회 시 모든 컬럼을 조회해 올 요소가
-- 사라지게 되어 데이터 조회 속도가 빨라진다.(조회 필요없는거 빼고 구성)

-- View 만드는 표현식
-- create view [view 이름] as [쿼리문]

create view  v_coureses_status as 

select
	c.course_id,
    c.title,
    count(e.enrollment_id) as '등록 학생 수'
from
	courses as c
left join
	enrollments as e on c.course_id = e.course_id
group by c.course_id, c.title;

select * from v_coureses_status;

-- view를 활용해서 등록 학생 수가 3명 이상인 과정의 
-- id, title, 학생 수를 조회하라.
select 
	id,
    title,
    `등록 학생 수`
from 
	v_coureses_status
where
	`등록 학생 수` >= 3;

-- view 삭제 
drop view v_coureses_status;

-- view 수정
-- creat or replace view 뷰이름 as 쿼리문 
create or replace view v_coureses_status as 
select
	c.course_id,
    c.title,
    c.status,
    count(e.enrollment_id) as '등록 학생 수'
from
	courses as c
left join
	enrollments as e on c.course_id = e.course_id
group by c.course_id, c.title;

select * from v_coureses_status;

