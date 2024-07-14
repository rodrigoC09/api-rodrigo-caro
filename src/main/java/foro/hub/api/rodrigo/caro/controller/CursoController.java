package foro.hub.api.rodrigo.caro.controller;

import foro.hub.api.rodrigo.caro.domain.curso.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public void crearCurso(@RequestBody @Valid DatosCrearCurso datosCrearCurso) {
        repository.save(new Curso(datosCrearCurso));
    }

    @GetMapping
    public Page<DatosListadoCurso> listadoCursos(@PageableDefault(sort = "nombre") Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListadoCurso::new);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody DatosActualizarCurso datosActualizarCurso){
        Curso curso = repository.getReferenceById(datosActualizarCurso.id());

        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id) {
        Curso curso = repository.getReferenceById(id);
    }

    /*@GetMapping("/{id}")
    public
    */

}
