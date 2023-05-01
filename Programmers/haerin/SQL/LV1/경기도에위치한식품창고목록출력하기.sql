-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
-- title : 경기도에 위치한 식품창고 목록 출력하기
-- Created by haerin on 2023-04-30
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
 (
  CASE FREEZER_YN
    WHEN 'Y' THEN 'Y' 
    ELSE 'N'
  END
 ) AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE WAREHOUSE_NAME LIKE '%경기%'
ORDER BY WAREHOUSE_ID;