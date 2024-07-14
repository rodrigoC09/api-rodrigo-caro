package foro.hub.api.rodrigo.caro.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

//    @Query("""
//            select t from Topico t
//            t.titulo
//
//            """)
//    Topico listarTopicos();

//    @Query("""
//            select t from Topico t
//            where t.id=:idTopico
//            """)
//    Topico findTopicoById(Long idTopicos);
}
