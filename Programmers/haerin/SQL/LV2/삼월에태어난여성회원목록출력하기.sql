-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
-- title : 3월에 태어난 여성 회원 목록 출력하기
-- created by haerin on 2023-05-31
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE MONTH(DATE_OF_BIRTH) = 3 && TLNO IS NOT NULL && GENDER = 'W'
ORDER BY MEMBER_ID;