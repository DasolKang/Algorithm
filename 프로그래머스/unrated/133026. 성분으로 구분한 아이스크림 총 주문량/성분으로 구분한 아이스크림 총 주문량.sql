-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order) total_order
FROM first_half 
JOIN icecream_info 
WHERE first_half.flavor=icecream_info.flavor
GROUP BY ingredient_type;