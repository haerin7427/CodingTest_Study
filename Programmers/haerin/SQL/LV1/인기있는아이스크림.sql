-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
-- title : 인기있는 아이스크림
-- Created by haerin on 2023-05-10
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;