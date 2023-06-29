-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
-- title : 우유와 요거트가 담긴 장바구니
-- created by haerin on 2023-06-29
SELECT A.CART_ID
FROM (SELECT CART_ID
    FROM CART_PRODUCTS 
    WHERE NAME = 'Milk') A
INNER JOIN (SELECT CART_ID
    FROM CART_PRODUCTS 
    WHERE NAME = 'Yogurt') B
ON A.CART_ID = B.CART_ID
ORDER BY 1;