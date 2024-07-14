package foro.hub.api.rodrigo.caro.domain.repuesta;

import foro.hub.api.rodrigo.caro.domain.topico.Topico;
import foro.hub.api.rodrigo.caro.domain.usuarios.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearRespuesta(
        @NotBlank
        String mensaje,

        @NotNull
        Long topico,

        //@NotNull
        //@Future
        LocalDateTime fecha_creacion,

        @NotNull
        Long usuario,

        @NotBlank
        String solucion
) {
}
