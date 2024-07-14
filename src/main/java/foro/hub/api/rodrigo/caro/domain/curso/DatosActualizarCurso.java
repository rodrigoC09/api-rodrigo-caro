package foro.hub.api.rodrigo.caro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(@NotNull Long id, String nombre, Categoria categoria) {
}
