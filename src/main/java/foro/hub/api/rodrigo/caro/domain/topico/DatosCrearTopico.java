package foro.hub.api.rodrigo.caro.domain.topico;

import foro.hub.api.rodrigo.caro.domain.curso.Curso;
import foro.hub.api.rodrigo.caro.domain.usuarios.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearTopico(


        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

//        @NotNull
//        @Future
        LocalDateTime fechaCreacion,

        @NotNull
        Boolean status,

        //@NotNull
        Long autor,

        //@NotNull
        Long curso




) {
}
