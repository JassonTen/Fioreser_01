package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.app.repository.PedidoRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;
    
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    
    public PedidoEntity createOrder(PedidoEntity pedido){
        return pedidoRepository.createPedido(pedido);
     }
    
    public Iterable<PedidoEntity> getOrders(){
        return pedidoRepository.getPedidos();
    }
    
    public Iterable<PedidoEntity> getOrderByUser(UsuarioEntity usuario){
        return pedidoRepository.getPedidoByUser(usuario);
    }
    
}
