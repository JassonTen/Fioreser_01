package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface PedidoCrudRepository extends CrudRepository<PedidoEntity, Integer> {
    public Iterable<PedidoEntity> findByUsuarioEntity(UsuarioEntity usuarioEntity);
}
