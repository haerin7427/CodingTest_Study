-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
-- title : 재구매가 일어난 상품과 회원 리스트 구하기

SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(ONLINE_SALE_ID) > 1
ORDER BY USER_ID, PRODUCT_ID DESC;