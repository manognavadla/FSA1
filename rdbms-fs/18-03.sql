/* Write a SQL query to list employee names and department names for employees with a salary greater than 2000 using INNER JOIN.


+-------+------------+
| ename | dname      |
+-------+------------+
*/
USE test; 
select e.ename,d.dname from emp e join dept d on e.deptno=d.deptno where e.sal>2000;


/* Write a SQL query to retrieve all employees and their department locations, 
including those without departments, using LEFT JOIN.

+--------+----------+
| ename  | location |
+--------+----------+
*/
USE test; 
select e.ename, d.location from emp e left join dept d on e.deptno=d.deptno;

/* Write a SQL query to list all department numbers, department names and their 
employee counts, including departments with no employees, using RIGHT JOIN.

+--------+------------+-----------+
| deptno | dname      | emp_count |
+--------+------------+-----------+
*/ 
USE test; 

select d.deptno, d.dname, count(e.ename) as emp_count from emp e right join dept d on e.deptno=d.deptno group by d.deptno ;/* Write a SQL query to simulate a FULL OUTER JOIN to list all employees and 
departments, including unmatched rows.

+-------+--------+--------+------------+
| empno | ename  | deptno | dname      |
+-------+--------+--------+------------+
*/
USE test; 
select e.empno, e.ename, d.deptno, d.dname from emp e left join dept d on d.deptno=e.deptno union select  e.empno, e.ename, d.deptno, d.dname from emp e right join dept d on d.deptno=e.deptno ;
/* Write a SQL query to find employees who are managers of other employees using 
a self-join.

+---------+
| manager |
+---------+
*/
USE test; 
select distinct e2.ename as manager from emp e1 inner join emp e2 on e1.mgr=e2.empno ;
/* Write a SQL query to generate all possible employee-department combinations 
using CROSS JOIN.

+--------+------------+
| ename  | dname      |
+--------+------------+
*/
USE test; 

select e.ename , d.dname from emp e cross join dept d;

/* Write a SQL query to list departments with employees earning more than 2500 
using EXISTS.

+--------+------------+
| deptno | dname      |
+--------+------------+
*/
USE test; 
select distinct dept.deptno,dept.dname from dept join emp on emp.deptno=dept.deptno where emp.sal>2500;
/* Write a SQL query to find departments with number of employees earning less 
than 1000 using NOT EXISTS.

+------------+--------+
| dname      | deptno |
+------------+--------+
*/
USE test; 
select dname,deptno from dept where not exists(select 1 from emp where emp.deptno=dept.deptno and emp.sal<1000);
/* Write a SQL query to find managers and the number of employees they manage in
departments located in 'New York', using the primary key and foreign key 
constraints.

+--------------+-----------+
| manager_name | emp_count |
+--------------+-----------+
*/
USE test; 
select e1.ename as manager_name,count(e2.empno) as emp_count from emp e1 join emp e2 on e1.empno=e2.mgr
join dept d on e1.deptno=d.deptno where d.location="New York" group by e1.ename;
/* Write a SQL query to list all employees and departments, including those 
without matches, using a simulated FULL JOIN.


+-------+--------+--------+------------+----------+
| empno | ename  | deptno | dname      | location |
+-------+--------+--------+------------+----------+
*/
USE test; 

select e.empno, e.ename, d.deptno, d.dname,d.location from emp e left join dept d on d.deptno=e.deptno union select  e.empno, e.ename, d.deptno, d.dname,d.location from emp e right join dept d on d.deptno=e.deptno ;
/* Write a SQL query to list employee names and department names where the 
department is in 'Chicago' using INNER JOIN.

+-------+-------+
| ename | dname |
+-------+-------+
*/
USE test; 
select e.ename, d.dname from emp e join dept d on e.deptno=d.deptno where d.location='Chicago';

/* 
Retrieve Department-wise Total Salary and Number of Employees (Using GROUP BY and JOIN)

+------------+---------------+--------------+
| dname      | num_employees | total_salary |
+------------+---------------+--------------+

*/
USE test; 
select d.dname,count(e.empno) as num_employees,sum(e.sal) as total_salary from dept d left join emp e on d.deptno=e.deptno group by d.dname;
/* Write a SQL query to list departments with no assigned employees using 
RIGHT JOIN.

+--------+---------+
| deptno | dname   |
+--------+---------+

*/
USE test; 
select d.deptno,d.dname from emp e right join dept d on e.deptno=d.deptno where e.empno is null;
/* Write a SQL query to combine employee and department data with duplicates 
using UNION ALL.


+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE test; 
select ename,dname from emp left join dept on emp.deptno=dept.deptno
union all 
select ename,dname from emp right join dept on emp.deptno=dept.deptno;
/* Write a SQL query to list employees and their managers’ names using a LEFT 
JOIN for employees without managers.

+----------+---------+
| employee | manager |
+----------+---------+

*/
USE test; 
select e1.ename as employee,e2.ename as manager from emp e1 left join emp e2 on e1.mgr=e2.empno;

/* Write a SQL query to retrieve average salaries per department using INNER 
JOIN and GROUP BY.

+--------+------------+-------------+
| deptno | dname      | avg_salary  |
+--------+------------+-------------+

*/
USE test; 
select dept.deptno,dept.dname, avg(emp.sal) as avg_salary from dept inner join emp on dept.deptno=emp.deptno group by dept.deptno,dept.dname;
/* Write a SQL query to find departments with more than 3 employees using 
INNER JOIN and HAVING.

+--------+----------+-----------+
| deptno | dname    | emp_count |
+--------+----------+-----------+

*/
USE test; 
select d.deptno,d.dname,count(e.empno) as emp_count from dept d inner join emp e on d.deptno=e.deptno group by d.deptno,d.dname having count(e.empno)>3;
/* Write a SQL query to list employees and departments where the employee’s 
hire date is after 1980 using INNER JOIN.

+--------+------------+------------+
| ename  | dname      | hiredate   |
+--------+------------+------------+
*/
USE test; 
select e.ename,d.dname,e.hiredate from emp e inner join dept d on e.deptno=d.deptno where e.hiredate>'1980-01-01';
/* 
Find Departments Without Employees (Using LEFT JOIN and NULL Check)

+------------+----------+
| Department | Location |
+------------+----------+


*/
USE test; 
select d.dname as department,d.location from dept d left join emp e on d.deptno=e.deptno where e.empno is null;
/* Write a SQL query to list employee names and department names using an
implicit join, ordered by employee name.

+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE test; 
select e.ename,d.dname from emp e join dept d on e.deptno=d.deptno order by e.ename;

