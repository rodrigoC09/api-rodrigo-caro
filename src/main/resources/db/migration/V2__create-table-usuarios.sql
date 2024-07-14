create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(250) not null,

    contrasena varchar(100) not null,


    primary key(id)
);