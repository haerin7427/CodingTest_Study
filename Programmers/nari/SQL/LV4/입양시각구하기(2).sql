-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
-- title : 입양 시각 구하기(2)

-- 변수선언
SET @hour := -1;

SELECT (@hour := @hour +1) AS HOUR, (
    SELECT COUNT(ANIMAL_ID)
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME) = @hour
) AS COUNT
FROM ANIMAL_OUTS
WHERE @hour < 23;