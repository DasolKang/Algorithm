-- 코드를 입력하세요
SELECT p.product_code product_code, p.price * SUM(s.sales_amount) sales
FROM product p
INNER JOIN offline_sale s
ON p.product_id = s.product_id
GROUP BY p.product_code
ORDER BY sales DESC, product_code;