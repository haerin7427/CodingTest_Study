-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
-- title : 재구매가 일어난 상품과 회원 리스트 구하기
-- created by haerin on 2023-06-02
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(product_id) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;