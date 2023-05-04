
DROP TABLE companies;

create table companies(objectid varchar(255), code varchar(50), licenseId varchar(255), name varchar(50), taxId varchar(25));
START TRANSACTION;
insert into companies (objectid,code,licenseId,name,taxId) values ('1A', '1231241', '143124', 'PWC', '2kj3');
insert into companies (objectid,code,licenseId,name,taxId) values ('2A', '1231242', '134132', 'Telefonica', 'kjh23');
insert into companies (objectid,code,licenseId,name,taxId) values ('3A', '1231243', '132412', 'Vodafone', '32kj');
insert into companies (objectid,code,licenseId,name,taxId) values ('4A', '1231244', '512343', 'Mediaset', '32lk');
insert into companies (objectid,code,licenseId,name,taxId) values ('5A', '1231245', '134124', 'El Mundo', '32k1');


COMMIT
