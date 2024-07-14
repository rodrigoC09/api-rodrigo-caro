package foro.hub.api.rodrigo.caro.controller;


import foro.hub.api.rodrigo.caro.domain.topico.*;
import foro.hub.api.rodrigo.caro.infra.errores.ValidacionDeIntegridad;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody @Valid DatosCrearTopico datosCrearTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) throws ValidacionDeIntegridad {
        Topico topico= topicoRepository.save(new Topico(datosCrearTopico));

        //Retornar 201
        DatosRespuestaTopico datosRespuestaTopico =new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId());
        //URL donde encontrar al topico
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListarTopico::new));

    }


    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());

        topico.actualizarDatosT(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico>retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId());

        return ResponseEntity.ok(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
