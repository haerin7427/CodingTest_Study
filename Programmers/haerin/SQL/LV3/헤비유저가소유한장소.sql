-- https://school.programmers.co.kr/learn/courses/30/lessons/77487
-- title : 헤비 유저가 소유한 장소
-- created by haerin on 2023-06-21
SELECT * FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID
               FROM PLACES
               GROUP BY HOST_ID
               HAVING COUNT(*) >= 2)
ORDER BY ID;