package foro.hub.api.rodrigo.caro.controller;

import foro.hub.api.rodrigo.caro.domain.usuarios.DatosAutenticacionUsuario;
import foro.hub.api.rodrigo.caro.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private UsuarioRepository repository;

    private void autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {

    }


}
