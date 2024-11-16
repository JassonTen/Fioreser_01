package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author FENIX
 */
@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPe;
    private LocalDateTime fechaCreada;
    private String status;
    private String total;
    
    @ManyToOne
    @JoinColumn (name="user_id")
    private UsuarioEntity usuarioEntity;

    @Transient
    private List<PedidoProductEntity> pedidoProducts;
     
    public PedidoEntity() {
    }

    public Integer getIdPe() {
        return idPe;
    }

    public void setIdPe(Integer idPe) {
        this.idPe = idPe;
    }

    public LocalDateTime getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(LocalDateTime fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public List<PedidoProductEntity> getPedidoProducts() {
        return pedidoProducts;
    }

    public void setPedidoProducts(List<PedidoProductEntity> pedidoProducts) {
        this.pedidoProducts = pedidoProducts;
    }

    public void addPedidoProduct(List<PedidoProductEntity>pedidoProducts){
       this.setPedidoProducts(pedidoProducts);
    }
    
    public BigDecimal getTotalPedidoPrice(){
        return getPedidoProducts().stream().map(p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
