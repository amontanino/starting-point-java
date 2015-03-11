
create table course (
  id varchar(255) not null ,
  email varchar(255) not null ,
  name varchar(255),
  surname varchar(255),
  primary key(id, email)
);

update schema_info set version = 1;

