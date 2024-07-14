package foro.hub.api.rodrigo.caro.domain.repuesta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(@NotNull Long id,String mensaje, String solucion) {
}
