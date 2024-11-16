package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.stereotype.*;
import www.fioreser.com.pe.app.repository.PedidoProductRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.PedidoProductEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class PedidoProductRepositoryImpl implements PedidoProductRepository{
    private final PedidoProductCrudRepository pedidoProductCrudRepository;

    public PedidoProductRepositoryImpl(PedidoProductCrudRepository pedidoProductCrudRepository) {
        this.pedidoProductCrudRepository = pedidoProductCrudRepository;
    }

    @Override
    public PedidoProductEntity createPedidoProduct(PedidoProductEntity pedidoProductEntity) {
        return pedidoProductCrudRepository.save(pedidoProductEntity);
    }

    @Override
    public Iterable<PedidoProductEntity> getPedidosProducts() {
        return pedidoProductCrudRepository.findAll();
    }

    @Override
    public Iterable<PedidoProductEntity> getPedidosProductsByPedido(PedidoEntity pedidoEntity) {
        return pedidoProductCrudRepository.findByPedidoEntity(pedidoEntity);
    }
    
    
}
