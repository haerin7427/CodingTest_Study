-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
-- title : DATETIME에서 DATE로 형 변환
-- Created by haerin on 2023-05-21
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;