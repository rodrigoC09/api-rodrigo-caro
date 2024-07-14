package foro.hub.api.rodrigo.caro.domain.repuesta;

import foro.hub.api.rodrigo.caro.domain.topico.Topico;
import foro.hub.api.rodrigo.caro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    private LocalDateTime fecha_creacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String solucion;

    public Respuesta(DatosCrearRespuesta datosCrearRespuesta) {
        this.mensaje = datosCrearRespuesta.mensaje();
        this.fecha_creacion = datosCrearRespuesta.fecha_creacion();
        this.solucion = datosCrearRespuesta.solucion();

    }


    public void actualizarDatosT(DatosActualizarRespuesta datosActualizarRespuesta) {
        if(datosActualizarRespuesta.mensaje() !=null){
            this.mensaje = datosActualizarRespuesta.mensaje();

        }
        if(datosActualizarRespuesta.solucion()!=null){
            this.solucion = datosActualizarRespuesta.solucion();

        }

    }
}
