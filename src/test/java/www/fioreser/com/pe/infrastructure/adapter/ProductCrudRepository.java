package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUsuarioEntity(UsuarioEntity usuarioEntity);
}
