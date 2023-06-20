-- https://school.programmers.co.kr/learn/courses/30/lessons/164670
-- title : 조건에 맞는 사용자 정보 조회하기
-- created by haerin on 2023-06-20
SELECT USER_ID, NICKNAME, CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS 전체주소, CONCAT(LEFT(tlno,3),"-",SUBSTR(tlno,4,4),"-",RIGHT(tlno,4)) AS "전화번호"
FROM USED_GOODS_USER
WHERE USER_ID IN (
    SELECT WRITER_ID
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(*) >= 3
)
ORDER BY USER_ID DESC;