package foro.hub.api.rodrigo.caro.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    public Curso(DatosCrearCurso datosCrearCurso) {
        this.nombre = datosCrearCurso.nombre();
        this.categoria = datosCrearCurso.categoria();
    }

    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if(datosActualizarCurso.nombre() !=null){
            this.nombre = datosActualizarCurso.nombre();
        }
        if(datosActualizarCurso.categoria() !=null){
            this.categoria = datosActualizarCurso.categoria();
        }



    }
}
