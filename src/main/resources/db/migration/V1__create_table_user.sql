drop table user if exists;

create table user (
  id bigint primary key auto_increment,
  name varchar(100) not null,
  lastName varchar(100) not null,
  email varchar2(100) not null,
  enabled boolean
)




