drop table counter_offers;
create table counter_offers (id int not null,name varchar(255) not null,vom varchar(255),originalPrice double not null,counterOfferPrice double not null,quantity double not null,primary key (id));
start transaction;
insert into counter_offers (id,name,vom,originalPrice,counterOfferPrice,quantity) values (1,"name1",'vom1',2.0,4.0,10.0);
insert into counter_offers (id,name,vom,originalPrice,counterOfferPrice,quantity) values (2,"name2",'vom2',2.0,4.0,10.0);
insert into counter_offers (id,name,vom,originalPrice,counterOfferPrice,quantity) values (3,"name3",'vom3',2.0,4.0,10.0);
insert into counter_offers (id,name,vom,originalPrice,counterOfferPrice,quantity) values (4,"name4",'vom4',2.0,4.0,10.0);
commit
