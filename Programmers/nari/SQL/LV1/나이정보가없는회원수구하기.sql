-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- title : 나이 정보가 없는 회원 수 구하기

SELECT COUNT(USER_ID)
FROM USER_INFO
WHERE AGE IS NULL;