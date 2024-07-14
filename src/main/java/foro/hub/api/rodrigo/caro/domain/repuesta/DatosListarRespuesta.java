package foro.hub.api.rodrigo.caro.domain.repuesta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosListarRespuesta(

        Long id,
        @NotBlank
        String mensaje,

        @NotNull
        Long topico,

        @NotNull
        @Future
        LocalDateTime fechaCreacion,

        @NotNull
        Long usuario,

        @NotBlank
        String solucion
) {
    public DatosListarRespuesta(Respuesta respuesta) {
        this(respuesta.getId() ,respuesta.getMensaje(), respuesta.getTopico().getId(), respuesta.getFecha_creacion(), respuesta.getUsuario().getId(), respuesta.getSolucion());
    }
}
