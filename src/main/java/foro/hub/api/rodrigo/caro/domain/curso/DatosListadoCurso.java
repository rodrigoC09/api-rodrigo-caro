package foro.hub.api.rodrigo.caro.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosListadoCurso(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria) {
    public DatosListadoCurso(Curso curso) {
        this(curso.getId() ,curso.getNombre(), curso.getCategoria().toString());
    }
}
