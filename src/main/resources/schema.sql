create table book
(
   isbn varchar(255),
   title varchar(255),
   cover varchar(255),
   publisher varchar(255),
   pages varchar(255),
   available varchar(255),
   primary key(isbn)
);

create table item
(
   title varchar(255),
   url varchar(255),
   price varchar(255)
);


  
insert into book(isbn, title, cover, publisher, pages, available)
values('10001','Goblet of Fire','Red','Marvel Comics','23','Yes');
insert into book(isbn, title, cover, publisher, pages, available)
values('10002','Lord of Rings','Blue','DC Comics','56','No');