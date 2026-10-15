-- distinct 
-- 중복된 값을 제거하는 것에 사용된다. 

select
	category_code
from 
	tbl_menu
order by
	category_code;
    
-- 메뉴테이블에 존재하는 카테고리 코드를 조회하라.
-- 단, 중복은 제거 
select
	distinct category_code  -- 중복 data가 존재하는 컬럼 앞
from 
	tbl_menu
order by
	category_code;
    