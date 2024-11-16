package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import www.fioreser.com.pe.app.repository.PedidoRepository;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
    
    private final PedidoCrudRepository pedidoCrudRepository;
    
    public PedidoRepositoryImpl(PedidoCrudRepository pedidoCrudRepository){
        this.pedidoCrudRepository = pedidoCrudRepository;
    }

    @Override
    public PedidoEntity createPedido(PedidoEntity pedido) {
        return pedidoCrudRepository.save(pedido);
    }

    @Override
    public Iterable<PedidoEntity> getPedidos() {
        return pedidoCrudRepository.findAll();
    }

    @Override
    public Iterable<PedidoEntity> getPedidoByUser(UsuarioEntity usuario) {
        return pedidoCrudRepository.findByUsuarioEntity(usuario);
    }
    
}
