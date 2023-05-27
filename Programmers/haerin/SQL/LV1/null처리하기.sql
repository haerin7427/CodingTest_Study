-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- title : NULL 처리하기
-- Created by haerin on 2023-05-26
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS;