package www.fioreser.com.pe.app.repository;

import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.PedidoProductEntity;

/**
 *
 * @author FENIX
 */
public interface PedidoProductRepository {
    
    public PedidoProductEntity createPedidoProduct(PedidoProductEntity pedidoProductEntity);
    public Iterable<PedidoProductEntity> getPedidosProducts();
    public Iterable<PedidoProductEntity> getPedidosProductsByPedido(PedidoEntity pedidoEntity);
    
}
