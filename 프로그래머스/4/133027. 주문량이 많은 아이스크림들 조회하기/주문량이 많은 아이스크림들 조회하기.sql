-- 코드를 입력하세요
-- 7월 아이스크림 총 주문량과 상반기 아이스크림 총 주문량을 더한 값 큰 순서로 3개의 맛 조회
WITH total_order AS (
    SELECT f.flavor, SUM(f.total_order) + SUM(j.total_order) AS total
    FROM first_half f
    JOIN july j ON f.flavor = j.flavor
    GROUP BY f.flavor
)

SELECT flavor
FROM total_order
ORDER BY total DESC
LIMIT 3;
