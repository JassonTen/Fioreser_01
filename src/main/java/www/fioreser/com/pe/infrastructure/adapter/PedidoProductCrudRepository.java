package www.fioreser.com.pe.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.PedidoProductEntity;

/**
 *
 * @author FENIX
 */
public interface PedidoProductCrudRepository extends CrudRepository<PedidoProductEntity, Integer> {
    List<PedidoProductEntity> findByPedidoEntity(PedidoEntity pedidoEntity);
}
