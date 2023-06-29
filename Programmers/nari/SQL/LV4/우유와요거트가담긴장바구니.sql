-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
-- title : 우유와 요거트가 담긴 장바구니

SELECT DISTINCT A.CART_ID
FROM CART_PRODUCTS AS A INNER JOIN CART_PRODUCTS AS B ON A.CART_ID = B.CART_ID
WHERE A.NAME = 'Milk' AND B.NAME = 'Yogurt'
ORDER BY A.CART_ID;