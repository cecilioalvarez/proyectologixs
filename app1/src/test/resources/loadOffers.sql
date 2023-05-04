create table Offers (
    id int not null,
    code varchar(255) not null,
    name varchar(255),
    description varchar(255),
    category varchar(255),
    primary key (id)
);

insert into Offers (id,code,name,description,category) values (1,'code1','name1','description1','category1');
insert into Offers (id,code,name,description,category) values (2,'code2','name2','description2','category2');
insert into Offers (id,code,name,description,category) values (3,'code3','name3','description3','category3');
insert into Offers (id,code,name,description,category) values (4,'code4','name4','description4','category4');
insert into Offers (id,code,name,description,category) values (5,'code5','name5','description5','category5');
