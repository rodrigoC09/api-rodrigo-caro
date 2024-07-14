package foro.hub.api.rodrigo.caro.controller;

import foro.hub.api.rodrigo.caro.domain.curso.Curso;
import foro.hub.api.rodrigo.caro.domain.curso.DatosActualizarCurso;
import foro.hub.api.rodrigo.caro.domain.topico.*;
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
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void crearTopico(@RequestBody DatosCrearTopico datosCrearTopico) {
        topicoRepository.save(new Topico(datosCrearTopico));
    }

    @GetMapping
    public Page<DatosListarTopico> listarTopicos(@PageableDefault(sort = "fecha_creacion", size = 10) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListarTopico::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());

        topico.actualizarDatosT(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico>retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId());

        return ResponseEntity.ok(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
