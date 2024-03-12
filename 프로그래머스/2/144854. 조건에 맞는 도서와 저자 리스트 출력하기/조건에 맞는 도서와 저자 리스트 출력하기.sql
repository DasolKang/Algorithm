-- 코드를 입력하세요

-- 출판일을 기준으로 오름차순 정렬
SELECT book_id, author_name, DATE_FORMAT(published_date, '%Y-%m-%d') as PUBLISHED_DATE
FROM book b
JOIN author a
ON b.author_id = a.author_id
-- 경제 카테고리에 속하는 도서
WHERE category = '경제'
ORDER BY published_date ASC