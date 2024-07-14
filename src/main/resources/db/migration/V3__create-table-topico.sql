create table topicos(

    id bigint not null auto_increment,
    titulo varchar(250) not null unique,
    mensaje varchar(250) not null unique,
    fechaCreacion datetime not null,
    status tinyint not null,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id),

    constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references  cursos(id)
);