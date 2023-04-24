-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
-- title : 이름이 있는 동물의 아이디

-- 정렬 기본값은 오름차순이라 따로 적어두지 않아도 됨
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
-- ORDER BY ANIMAL_ID;