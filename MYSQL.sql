create database java_crud;
use java_crud;

create table conta(
login varchar(40),
senha varchar(40));

insert into conta(login,senha)
values
("Jose", "123"),
("Alice","456");

select * from conta;


CREATE USER 'seu_usuario'@'localhost' IDENTIFIED BY 'sua_senha';
GRANT ALL PRIVILEGES ON java_crud.* TO 'seu_usuario'@'localhost';
FLUSH PRIVILEGES;
