package foro.hub.api.rodrigo.caro.domain.topico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

//        @NotNull
//        @Future
        LocalDateTime fechaCreacion,

        @NotNull
        Boolean status,

        @NotNull
        Long usuario,

        @NotNull
        Long curso
) {
}
