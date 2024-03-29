-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
-- title : 보호소에서 중성화한 동물
-- created by haerin on 2023-06-20
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.ANIMAL_TYPE, ANIMAL_INS.NAME
FROM ANIMAL_INS INNER JOIN ANIMAL_OUTS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.SEX_UPON_INTAKE LIKE 'Intact%' and ANIMAL_OUTS.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY ANIMAL_INS.ANIMAL_ID;