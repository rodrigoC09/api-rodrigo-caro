create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(250) not null,
    correoElectronico varchar(250) not null unique,
    contrasena varchar(100) not null,
    perfiles varchar(200) not null,

    primary key(id)
);