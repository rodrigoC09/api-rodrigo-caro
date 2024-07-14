package foro.hub.api.rodrigo.caro.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("""
//            select u.nombre, u.contrasena
//            from Usuario u
//            where u.nombre=:username
//            """)
    UserDetails findByNombre(String username);
}
