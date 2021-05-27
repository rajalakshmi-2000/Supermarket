create database new;
use new;
drop table stock;
create table stock(item_id int(5) primary key not null auto_increment,item_name varchar(25),qty int(5),price varchar(10),tax int(5));
insert into stock (item_name,qty,price,tax)  values('apple',200,'200',2);
insert into stock (item_name,qty,price,tax)  values('orange',50,'180',1);
insert into stock (item_name,qty,price,tax) values('guava',100,'100',2);
insert into stock (item_name,qty,price,tax) values('pomogrenate',200,'500',4);
insert into stock (item_name,qty,price,tax) values('banana',100,'150',2);
insert into stock (item_name,qty,price,tax) values('grapes',100,'60',3);
insert into stock (item_name,qty,price,tax) values('mango',50,'200',5);
insert into stock (item_name,qty,price,tax) values('strawberry',100,'120',1);
insert into stock (item_name,qty,price,tax) values('sweetlime',200,'200',2);
insert into stock (item_name,qty,price,tax) values('sapota',100,'150',2);
insert into stock (item_name,qty,price,tax) values('onion',500,'200',3);
insert into stock (item_name,qty,price,tax) values('tomato',500,'200',3);
insert into stock (item_name,qty,price,tax) values('chillies',100,'50',2);
insert into stock (item_name,qty,price,tax) values('potato',1000,'200',5);
insert into stock (item_name,qty,price,tax) values('mango-raw',500,'300',2);
insert into stock (item_name,qty,price,tax) values('carrot',100,'250',2);
insert into stock (item_name,qty,price,tax) values('beans',400,'500',2);
insert into stock (item_name,qty,price,tax) values('banana-raw',100,'200',2);
insert into stock (item_name,qty,price,tax) values('beetroot',150,'200',2);
insert into stock (item_name,qty,price,tax) values('raddish',100,'150',2);
insert into stock (item_name,qty,price,tax) values('soap',500,'32',1);
insert into stock (item_name,qty,price,tax) values('toothpate',500,'50',2);
insert into stock (item_name,qty,price,tax) values('toor dal',1000,'150',4);
insert into stock (item_name,qty,price,tax) values('urad dal',1000,'200',4);
insert into stock (item_name,qty,price,tax) values('jeera',500,'300',2);
insert into stock (item_name,qty,price,tax) values('pepper',500,'200',6);
insert into stock (item_name,qty,price,tax) values('mustard',1000,'200',2);
insert into stock (item_name,qty,price,tax) values('sunflower oil',1000,'200',5);
insert into stock (item_name,qty,price,tax) values('coconut oil',1000,'600',02);
insert into stock (item_name,qty,price,tax) values('fenugreek',800,'500',2);


select * from stock;

use new;
drop table Employee;
create table Employee( eid int(5) primary key not null auto_increment, ename varchar(25), Designation varchar(25),salary int(7), username varchar(25), password varchar(25));
insert into Employee (ename, Designation, salary, username,password) values('sakthi','billing',20000,'sakthi','sak23');
insert into Employee (ename, Designation, salary, username,password) values('raji', 'billing',20000,'raji','raji03');
insert into Employee (ename, Designation, salary, username,password) values('shalini','billing',20000,'shalini','sha123');
insert into Employee (ename, Designation, salary, username,password) values('akanksha','helper',10000,'akanksha','aka55');
insert into Employee (ename, Designation, salary, username,password) values('sara', 'helper',10000,'sara','sar67');
insert into Employee (ename, Designation, salary, username,password) values('ram', 'helper',10000,'ram','ram14');
insert into Employee (ename, Designation, salary, username,password) values('chris','packing',12000,'chris','chri06');
insert into Employee (ename, Designation, salary, username,password) values('jacob','packing',12000,'jacob','jac66');
insert into Employee (ename, Designation, salary, username,password) values('lakshman','cleaning',8000,'lakshman','lak07');
insert into Employee (ename, Designation, salary, username,password) values('rishi', 'cleaning',8000,'rishi','ris29');
select * from Employee;

use new;
create table Customer(cust_id int(5) primary key not null auto_increment, cname varchar(25), phone varchar(11),address varchar(50),points int (5));
insert into Customer (cname,phone,address,points) values('arjun','7895622365','no.12, 18th main road,annn nagar',10);
insert into Customer (cname,phone,address,points) values('reshma','9985654972','no.1, 13th main road,adyar',5);
insert into Customer (cname,phone,address,points) values('geetha','9444485412','evergreen apartments, 18th main road,annn nagar',15);
insert into Customer (cname,phone,address,points) values('karthik','8854574299','no.12, 18th street,avadi',10);
insert into Customer (cname,phone,address,points) values('gayathri','7584621299','no.17, 12 th main road ,annn nagar',20);
insert into Customer (cname,phone,address,points) values('adi','7708947390','no.13 24th street anna nagar',25);
insert into Customer (cname,phone,address,points) values('abi','9444495379','no.13 24th street anna nagar',25);
select * from Customer;
drop table bill;
create table bill(i_id int(5),i_name varchar(25),qty int(5),total int(5),tax int(5)); 


