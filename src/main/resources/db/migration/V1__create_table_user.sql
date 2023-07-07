drop table user if exists;

create table user (
  id        bigint primary key auto_increment,
  name      varchar(100) not null,
  last_name varchar(100) not null,
  password  varchar(100) not null,
  email     varchar(100) ,
  enabled   boolean
)




