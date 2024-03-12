-- 코드를 입력하세요
SELECT user_id, nickname, sum(b.price) as TOTAL_SALES
FROM used_goods_board b
JOIN used_goods_user u
ON user_id = writer_id
WHERE status = 'DONE'
GROUP BY user_id
HAVING total_sales >= 700000
ORDER BY total_sales ASC;