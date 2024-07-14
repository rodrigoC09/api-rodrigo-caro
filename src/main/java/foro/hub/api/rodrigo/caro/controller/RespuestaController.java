package foro.hub.api.rodrigo.caro.controller;

import foro.hub.api.rodrigo.caro.domain.repuesta.*;
import foro.hub.api.rodrigo.caro.domain.topico.DatosActualizarTopico;
import foro.hub.api.rodrigo.caro.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/respuestas")

public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public void crearRespuesta(@RequestBody @Valid DatosCrearRespuesta datosCrearRespuesta) {
        respuestaRepository.save(new Respuesta(datosCrearRespuesta));
    }

    @GetMapping
    public Page<DatosListarRespuesta> listarRespuestas(@PageableDefault(sort = "mensaje")Pageable paginacion) {
        return respuestaRepository.findAll(paginacion).map(DatosListarRespuesta::new);
    }

    @PutMapping
    @Transactional
    public void actualizarRespuesta(@RequestBody DatosActualizarRespuesta datosActualizarRespuesta){
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());

        respuesta.actualizarDatosT(datosActualizarRespuesta);
    }
}
