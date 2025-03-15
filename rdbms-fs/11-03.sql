/*1  Retrieve the names and salaries of employees who have the job title "SALESMAN" and earn more than 1500.

Expected Output Columns:
+------------+-----------+
| ename      | sal       |
+------------+-----------+


*/
USE test; select ename, sal from emp where job="SALESMAN" and sal>1500;
/* 2 List all employees whose job title is either "MANAGER" or "ANALYST".

Expected Output Columns:
+------------+-----------+
| ename      | job       |
+------------+-----------+


*/
USE test; 
select ename, job from emp where job= "MANAGER" or job="ANALYST";
/* 3 Get all the details of employees who do not belong to department 20.

*/
USE test;
select * from emp where deptno<> 20;
/*4  Get the employee names and their commission details 
where the job is "CLERK" or the commission is more than 1000.

Expected Output Columns:
+--------+----------+---------+
| ename  | job      | comm    |
+--------+----------+---------+

*/
USE test;
select ename, job, comm from emp where job="CLERK" or comm>1000;
/* 5 Get the list of employees who do not have the job title "CLERK" or "SALESMAN".

Expected Output Columns:
+--------+----------+
| ename  | job      |
+--------+----------+

*/
USE test;
select ename, job from emp where job not in ("CLERK", "SALESMAN");
/* 6 Retrieve the names and salaries of employees who earn between 1000 and 3000 (inclusive).

Expected Output Columns:
+--------+----------+
| ename  | sal      |
+--------+----------+

*/
USE test;
select ename, sal from emp where sal between 1000 and 3000;
/*7  Retrieve employees who were hired between the years 1995 and 1999.

Expected Output Columns:
+--------+----------+
| ename  | hiredate |
+--------+----------+

*/
USE test;
select ename, hiredate from emp where (hiredate between '95-01-01' and '1999-12-31');
/* 8 Retrieve employees who earn a commission between 300 and 1000.

Expected Output Columns:
+--------+----------+
| ename  | comm     |
+--------+----------+

*/
USE test;
select ename, comm from emp where comm between 300 and 1000;
/* 9 Retrieve employees who are part of department numbers between 20 and 40.

Expected Output Columns:
+--------+----------+
| ename  | deptno   |
+--------+----------+

*/
USE test;
select ename, deptno from emp where deptno>=20 and deptno<=40;
/*10  List all salary grades where the grade is between 2 and 4.

Expected Output Columns:
+------+----------+------------+
|grade |    losal |   hisal    |
+------+----------+------------+

*/
USE test;
select grade, losal, hisal from salgrade where grade>=2 and grade<=4;
/* 11 Get employees who are not managers and have a salary below 2000.

Expected Output Columns:
+------+----------+------------+
|ename |    job   |   sal      |
+------+----------+------------+

*/
USE test;
select ename, job, sal from emp where job <> "MANAGER" and sal<2000;
/*12  Retrieve employees who do not report to any manager.

Expected Output Columns:
+------+----------+------------+
|ename |    job   |   mgr      |
+------+----------+------------+

*/
USE test;
select ename, job, mgr from emp where mgr is null;
/*13 Get clerks or analysts hired between 1996 and 2000

Expected Output Columns:
+------+-------+------------+
| ID   | Name  | StartDate  |
+------+-------+------------+

*/
USE test;
select empno as ID,ename as  Name, hiredate as StartDate from  emp where (hiredate between '96/01/01' and '2000/12/31') and job  in ("CLERK","ANALYST");
-- select empno as ID,ename as  Name, hiredate as StartDate from  emp where year(hiredate) between 1996 and 2000 and job  in ("CLERK","ANALYST");

/*14  List employees with mgr 7788 or 7566 and sal < 3000

Expected Output Columns:
+----------+------+---------+
| Employee | Boss | Salary  |
+----------+------+---------+

*/
USE test;
select ename as Employee, mgr as Boss, sal as Salary from emp where mgr in (7788,7566) and sal<3000;
/* 15 Retrieve employees with 'ar' anywhere in their name

Expected Output Columns:
+-------+--------+----------+------+------------+---------+---------+--------+
| empno | ename  | job      | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+----------+------+------------+---------+---------+--------+

*/
USE test;
select * from emp where ename like '%ar%';
/* 16 Retrieve employees with exactly 5-letter names starting with 'K'.

Expected Output Columns:
+-------+--------+----------+------+------------+---------+---------+--------+
| empno | ename  | job      | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+----------+------+------------+---------+---------+--------+

*/
USE test;
select * from emp where ename like'K____';
/* 17 Retrieve employees whose names do not end with 'n'.

Expected Output Columns:
+-------+--------+----------+------+------------+---------+---------+--------+
| empno | ename  | job      | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+----------+------+------------+---------+---------+--------+

*/
USE test;
select * from emp where ename not like '%n';
/* 18 Retrieve which employees have names starting with 'C' or 'S'.

Expected Output Columns:
+-------+--------+----------+------+------------+---------+---------+--------+
| empno | ename  | job      | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+----------+------+------------+---------+---------+--------+

*/
USE test;
select * from emp where ename regexp '^[cs]';
/* 19 Perform Sum of salaries and commissions by dept 30 

Expected Output Columns:
+----------+------------+
| TotalPay | TotalBonus |
+----------+------------+

*/
USE test;
select sum(sal) as TotalPay, sum(comm) as TotalBonus from emp where deptno=30;
/* 20 Get Max and min salaries in dept 20 or 40

Expected Output Columns:
+------------+-----------+
| HighestPay | LowestPay |
+------------+-----------+

*/
USE test;
select max(sal) as HighestPay, min(sal) as LowestPay from emp where deptno in (20,40);