 connect 'jdbc:derby:shopmedb;create=true';

create table customer (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  name varchar(100),
  password varchar(100),
  email varchar(100),
  isadmin boolean default false;
);

INSERT into customer(name,password,email) values ('Admin','1234','admin@admin.com',true);


create table item (
  itemid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
  itemname varchar(100),
  itemdescription varchar(100),
  itemquanity INTEGER,
  itemprice decimal(10,2),
  sellerid INTEGER,
  itemstatus boolean default false;
);

create table finalorder (
   orderid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
   itemid INTEGER,
   itemname varchar(100),
   itemquanity INTEGER,
   itemprice decimal(10,2),
   buyerid INTEGER
);