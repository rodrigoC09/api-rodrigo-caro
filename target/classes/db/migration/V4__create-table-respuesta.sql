create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(250) not null,
    topico_id bigint not null,
    fechaCreacion datetime not null,
    autor_id bigint not null,
    solucion varchar(250) not null,

    primary key(id),

    constraint fk_respuestas_autor_id foreign key(autor_id) references usuarios(id),
    constraint fk_respuestas_topico_id foreign key(topico_id) references  topicos(id)
);