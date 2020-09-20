select Email from
(
  select Email, count(Email) as num
  from Person
  group by Email
) as statistic
where num > 1
;
#use original function count to get data numbers
#select as a new table
#as statistic mains that the result store as a tempture table named statistic
#使用原生函数count来计数
#查询查询后的结果