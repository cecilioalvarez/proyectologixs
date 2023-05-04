drop table if exists sales;
create table sales (id varchar(20),ownerId varchar(20),clientId varchar(20),code varchar(20),offerId varchar(20),counterOfferId varchar(20),isCounterOffer boolean);
START TRANSACTION;
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0001","0001","0001","1A","1","1",true);
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0002","0002","0002","2A","2","2",true);
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0003","0003","0003","3A","3","3",false);
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0004","0004","0004","4A","4","4",false);
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0005","0005","0005","5A","5","5",true);
insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values ("0006","0006","0006","6A","6","6",false);
COMMIT