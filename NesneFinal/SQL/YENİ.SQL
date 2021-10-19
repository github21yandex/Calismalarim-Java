insert into tbl_Project
   (project_Name, ProjectType_Id)
Values
   ('Malzeme Alım Programı', 1)


update tbl_Customer
set Address='Organize Sanayi Bölgesi, Denizli',Phone='375-4789'
where Customer_Name='ABC Ltd. Şirketi'

update tbl_Employee_Project
set FinishDate=getdate()
where Employee_Id=(select Id
from tbl_Employee
where name='Ali' and LastName='Yılmaz')
delete from tbl_Employee where name='Ali' and LastName='Yılmaz'


select *
from tbl_Project
order by projectType_Id


declare @a int  ,@b int

set @a=(SELECT max(Price)
FROM tbl_Project_Sales)

set @b =(select Customer_Id
from tbl_Project_Sales
where Price=@a)

select *
from tbl_Customer
where Customer_Id=@b

SELECT TOP 1
   c.Customer_Name, c.Address, c.Phone, SUM(p.Price)AS pricetoplam
FROM tbl_Customer c, tbl_Project_Sales p
WHERE p.Customer_Id=c.Customer_Id
GROUP BY c.Customer_Name,c.Address,c.Phone
ORDER BY pricetoplam DESC

SELECT B.Customer_Name, A.*
from tbl_Customer B join tbl_Project_Sales A on A.Customer_Id=B.Customer_Id
order by Sell_Date asc

SELECT distinct p.Project_Name
from tbl_Project_Sales s join tbl_Project p on s.Project_Id=p.Project_Id
where Sell_Date > DATEADD(year,-1,getdate())

SELECT tbl_Project.Project_Name
from tbl_Department_Project_Control inner join tbl_Project on tbl_Department_Project_Control.Project_Id=tbl_Project.Project_Id
where tbl_Department_Project_Control.FinishDate is null

SELECT *
from tbl_Customer
where Customer_Name like ('%Şirket%') or Customer_Name like ('%Ltd.%')

SELECT tbl_Project.Project_Id, tbl_Project.Project_Name, tbl_Project.projectType_Id, tbl_Project.finishDate
from tbl_Project inner join tbl_Project_Sales on tbl_Project.Project_Id=tbl_Project_Sales.Project_Id
where finishDate is NULL