# Write your MySQL query statement below
SELECT
    id,
    CASE
        WHEN T.p_id IS NULL THEN 'Root' # null 인곳은 꼭대기
        WHEN T.id IN (SELECT T2.p_id FROM Tree AS T2) THEN 'Inner' # 트리에 연결되는 부분(inner)이 있는 경우임
        ELSE 'Leaf'
    END AS type
FROM
    Tree AS T;