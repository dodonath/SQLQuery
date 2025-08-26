SELECT t1.column1,
       t1.column2,
       t1.column3
FROM   table1 t1
WHERE  t1.column1 = 1
AND    t1.column2 > 1
AND    t1.column2 < 1
AND    t1.column2 >= 1
AND    t1.column2 <= 1
AND    t1.column2 BETWEEN 1 AND    2
AND    t1.column2 LIKE '%'1' %'
AND    t1.column2 != 1
AND    t1.column2 IS NULL
AND    t1.column2 IS NOT NULL