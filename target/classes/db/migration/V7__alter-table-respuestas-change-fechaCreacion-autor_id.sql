alter table respuestas change fechaCreacion fecha_creacion datetime not null;
alter table respuestas change autor_id usuario_id bigint not null;