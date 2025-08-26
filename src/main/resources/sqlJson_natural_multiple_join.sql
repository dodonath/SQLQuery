SELECT   t11.column1,
         t11.column2,
         t11.column3
FROM     (
                SELECT t1.column1,
                       t1.column2,
                       t1.column3
                FROM   table1 t1
                WHERE  t1.column1 = 1) t11 ,
         (
                SELECT t3.column1,
                       t3.column2,
                       t3.column3
                FROM   table3 t3
                WHERE  t3.column1 = 1) t33,
         (
                SELECT t4.column1,
                       t4.column2,
                       t4.column3
                FROM   table4 t4
                WHERE  t4.column1 = 1) t34
WHERE    t11.column2 = t33.column1
AND      t11.column2 = t34.column1
AND      t11.column1 =
         (
                SELECT t2.column1
                FROM   table2 t2
                WHERE  t2.column1 IN ('1' ,
                                      '2' ,
                                      '3' ))
AND      t11.column2 > 1
AND      t11.column2 < 1
AND      t11.column2 >= 1
AND      t11.column2 <= 1
AND      t11.column2 BETWEEN 1 AND      2
AND      t11.column2 LIKE '%'1' %'
AND      t11.column2 != 1
OR       t11.column2 IS NULL
OR       t11.column2 IS NOT NULL
ORDER BY t11.column2 ASC