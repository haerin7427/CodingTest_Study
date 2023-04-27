-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- title : 어린 동물 찾기
-- Created by haerin on 2023-04-27
SELECT ANIMAL_ID, NAME 
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;