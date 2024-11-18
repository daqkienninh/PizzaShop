drop database Assingment_Data

create database Assignment_Data
create table Account(
AccountID varchar(15) primary key,
UserName varchar(100) not null,
Password varchar (50) not null,
FullName varchar (100) not null,
Type bit not null
);

insert into Account(AccountID,UserName,Password,FullName,Type)
values('1','Tom','123','Tom Cat','1'),
('2','Nick','234','Nick Nick','0'),
('3','Mark','345','Mark Brown','0');

select * from Account;

create table Customers(
CustomerID varchar(15) primary key,
Password varchar(50) not null,
ContactName varchar(50),
Address varchar(255) not null,
Phone int
);

create table Categories(
CategoryID varchar(15) primary key,
CategoryName varchar(20) not null,
Description varchar(255)
);

create table Suppliers(
SupplierID varchar(15) primary key,
CompanyName varchar(255) not null,
Address varchar(255),
Phone int
);

create table Orders(
OrderID varchar(15) primary key,
CustomerID varchar(15),
OrderDate date not null,
RequiredDate date not null,
ShippedDate date not null,
Freight float not null,
ShipAddress varchar(255) not null
foreign key (CustomerID) references Customers (CustomerID)
);

create table Products(
ProductID varchar(15) primary key,
ProductName varchar(50) not null,
SupplierID varchar(15),
CategoryID varchar(15),
QuantityPerUnit int,
UnitPrice float,
ProductImage varchar(50),
foreign key(SupplierID) references Suppliers(SupplierID),
foreign key(CategoryID) references Categories(CategoryID),
);

create table Order_Details(
OrderID varchar(15),
ProductID varchar(15),
primary key(OrderID, ProductID),
UnitPrice float,
Quantity int,
foreign key(OrderID) references Orders(OrderID),
foreign key(ProductID) references Products(ProductID)
);