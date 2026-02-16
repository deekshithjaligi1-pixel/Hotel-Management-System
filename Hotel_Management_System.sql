CREATE DATABASE Hotel_Management_System;
USE Hotel_Management_System;
Show tables;

CREATE TABLE Login (username VARCHAR(25) , Password VARCHAR(25));
select * From Login;
insert into Login values("admin",12345);

create TABLE employee (name varchar(25), age varchar(10), gender varchar(20),Job varchar(25), Salary varchar(25), Phone varchar(10),Email varchar(30),aadhar varchar(30));
describe employee;
select * from employee;

create TABLE AddRooms (Roomadded varchar(10), availability varchar(25), cleaningStatus varchar(25),Price varchar(25) , BedPrice varchar(25));
select * from AddRooms;

create TABLE AddDriver (name varchar(20), age varchar(10), gender varchar(10),carcompany varchar(20) , carmodel varchar(25),available varchar(20), location varchar(25));
select * from AddDriver;

create TABLE Customer (Id varchar(20), number varchar(10), gender varchar(10),Country varchar(30), AllocatedRoom varchar(30), Time varchar(50),Deposit varchar(10));
select *from Customer;

create TABLE Department (department varchar(30), dudget varchar(30));
insert into Department values ("Front Office","500000");
insert into Department values ("HouseKeeping","40000");
insert into Department values ("Food and Beverage","23000");
insert into Department values ("Kitchen or Beverage","540000");
insert into Department values ("Security","320000");
select * from Department;

