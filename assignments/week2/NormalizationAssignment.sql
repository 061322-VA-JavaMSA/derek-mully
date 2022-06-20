--table
create table SalesStaff(
	EmployeeID SERIAL primary key,
	Name varchar(30),
	SalesOfficeCity varchar(30),
	Age int,
	DateofBirth varchar(30),
	CustomerNames varchar(100),
);
