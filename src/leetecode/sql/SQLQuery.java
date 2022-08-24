package leetecode.sql;

public class SQLQuery {

    //https://leetcode.com/problems/second-highest-salary/submissions/
    //SELECT (select distinct salary from Employee order by salary desc LIMIT 1 OFFSET 1) AS SecondHighestSalary


    //-----------------
    //https://leetcode.com/problems/combine-two-tables/
    //select p.FirstName, p.LastName, a.City, a.State from Person p left join Address a on p.PersonId = a.PersonId

}

//https://leetcode.com/problems/employees-earning-more-than-their-managers/
//select a.Name as Employee from Employee a, Employee b where a.managerid = b.id and a.salary > b.salary


//https://leetcode.com/problems/duplicate-emails/submissions/
//select a.email from (select count(email) as cnt, email from person group by email) as a where a.cnt >=2



//https://leetcode.com/problems/customers-who-never-order/submissions/
//select name as Customers from Customers where id not in (select distinct CustomerId from Orders)


//https://leetcode.com/problems/department-highest-salary/solution/
//select b.dname as Department, a.name as Employee, a.salary as Salary from employee a,
//        (select Max(Salary) as maxsal, departmentid, d.name as dname from Employee e, Department d where e.departmentid = d.id group by departmentid) as b
//        where a.salary=maxsal and a.DepartmentId=b.departmentid



//https://leetcode.com/problems/delete-duplicate-emails/submissions/
//Delete p1 from person p1, person p2 where p1.email=p2.email and p1.id>p2.id


//https://leetcode.com/problems/rising-temperature/submissions/
//select wc.id from weather wc, weather wp where wc.recorddate = (wp.recorddate+1) and wc.temperature > wp.temperature