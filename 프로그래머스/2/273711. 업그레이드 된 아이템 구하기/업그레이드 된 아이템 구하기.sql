-- 코드를 작성해주세요
SELECT i.item_id, item_name, rarity
FROM item_info i
JOIN item_tree t
ON i.item_id = t.item_id
WHERE t.parent_item_id IN (
    SELECT item_id
    FROM item_info i
    WHERE rarity='RARE'
)
ORDER BY i.item_id DESC