package foro.hub.api.rodrigo.caro.domain.topico;

import foro.hub.api.rodrigo.caro.domain.curso.Curso;
import foro.hub.api.rodrigo.caro.domain.usuarios.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosListarTopico(

        Long id,
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        @Future
        LocalDateTime fecha_creacion,

        @NotNull
        Boolean status,

        @NotNull
        Long usuario,

        @NotNull
        Long curso
        ) {
    public DatosListarTopico(Topico topico) {
        this(topico.getId() ,topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId());
    }
}
