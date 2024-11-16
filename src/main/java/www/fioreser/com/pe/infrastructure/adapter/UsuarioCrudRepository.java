package www.fioreser.com.pe.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface UsuarioCrudRepository extends CrudRepository<UsuarioEntity, Integer>{
    //METODO ADICIONAL NO TIENE EL CRUD REPOSITORY
    public Optional<UsuarioEntity> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
