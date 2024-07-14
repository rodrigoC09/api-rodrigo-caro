package foro.hub.api.rodrigo.caro.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje
//        Long usuario,
//        Long curso

) {
}
