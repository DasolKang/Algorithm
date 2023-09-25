SELECT f.flavor
FROM first_half f
LEFT JOIN icecream_info info ON f.flavor = info.flavor
WHERE total_order>3000
AND ingredient_type= "fruit_based"
ORDER BY total_order DESC;