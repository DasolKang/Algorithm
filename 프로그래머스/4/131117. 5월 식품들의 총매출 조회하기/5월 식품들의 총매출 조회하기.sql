-- 코드를 입력하세요
SELECT f.product_id, f.product_name, f.price*SUM(o.amount) total_sales
FROM food_product f
LEFT JOIN food_order o
ON f.product_id = o.product_id
WHERE o.produce_date BETWEEN DATE('2022-05-01') AND DATE('2022-05-31')
GROUP BY product_id
ORDER BY total_sales DESC, product_id