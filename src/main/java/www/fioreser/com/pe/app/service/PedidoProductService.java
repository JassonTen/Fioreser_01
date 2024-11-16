package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.app.repository.PedidoProductRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.PedidoProductEntity;

/**
 *
 * @author FENIX
 */
public class PedidoProductService {

    private final PedidoProductRepository pedidoProductRepository;

    public PedidoProductService(PedidoProductRepository pedidoProductRepository) {
        this.pedidoProductRepository = pedidoProductRepository;
    }

    public PedidoProductEntity createOrder(PedidoProductEntity pedidoProductEntity) {
        return pedidoProductRepository.createPedidoProduct(pedidoProductEntity);

    }

    public Iterable<PedidoProductEntity> getOrdersProducts() {
        return pedidoProductRepository.getPedidosProducts();
    }

    public Iterable<PedidoProductEntity> getOrdersProductByOrder(PedidoEntity pedidoEntity) {
        return pedidoProductRepository.getPedidosProductsByPedido(pedidoEntity);
    }

}
