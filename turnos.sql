#drop schema dam2tm06uf4p1;
create schema dam2tm06uf4p1;
use dam2tm06uf4p1;

create table consultas(
 id int primary key auto_increment,
 nombre varchar(255) unique,
 marcado boolean
);


