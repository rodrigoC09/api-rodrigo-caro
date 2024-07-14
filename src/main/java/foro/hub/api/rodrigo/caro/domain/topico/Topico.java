package foro.hub.api.rodrigo.caro.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import foro.hub.api.rodrigo.caro.domain.curso.Curso;
import foro.hub.api.rodrigo.caro.domain.repuesta.Respuesta;
import foro.hub.api.rodrigo.caro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;


    private LocalDateTime fechaCreacion;

    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Topico(DatosCrearTopico datosCrearTopico) {
        this.titulo = datosCrearTopico.titulo();
        this.mensaje =datosCrearTopico.mensaje();
        this.fechaCreacion =datosCrearTopico.fechaCreacion();
        this.status=datosCrearTopico.status();
        //this.autor =datosCrearTopico.autor();
        //this.curso=datosCrearTopico.curso();
    }

    public void actualizarDatosT(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() !=null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() !=null) {
            this.mensaje =datosActualizarTopico.mensaje();
        }


        //this.usuario = datosActualizarTopico.usuario();
    }
}
