# Write your MySQL query statement below
SELECT
    s.stock_name,
    SUM(
            CASE 
            WHEN s.operation = 'Sell' THEN s.price 
            ELSE -s.price 
            END
        ) AS capital_gain_loss
FROM
    Stocks as s
GROUP BY
    s.stock_name;