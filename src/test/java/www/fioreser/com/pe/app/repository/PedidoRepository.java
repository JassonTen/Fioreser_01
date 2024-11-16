package www.fioreser.com.pe.app.repository;

import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface PedidoRepository {
    
    public PedidoEntity createPedido(PedidoEntity pedido);
    
    //Pedidos para el admin del sistema
    public Iterable<PedidoEntity> getPedidos();
    
    //Pedidos por usuario logeado en el sistema
    public Iterable<PedidoEntity> getPedidoByUser(UsuarioEntity usuario);
    
}
