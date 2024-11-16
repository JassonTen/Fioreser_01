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
    
    public PedidoEntity createPedido(PedidoEntity pedido){
        return pedidoRepository.createPedido(pedido);
     }
    
    public Iterable<PedidoEntity> getPedidos(){
        return pedidoRepository.getPedidos();
    }
    
    public Iterable<PedidoEntity> getPedidoByUser(UsuarioEntity usuario){
        return pedidoRepository.getPedidoByUser(usuario);
    }
    
}
