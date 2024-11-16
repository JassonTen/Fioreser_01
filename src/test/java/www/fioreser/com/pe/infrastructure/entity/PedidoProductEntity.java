package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
/**
 *
 * @author FENIX
 */
@Entity
@Table(name = "pedidosproducts")
public class PedidoProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPP;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedidoEntity;

    public PedidoProductEntity() {
    }

    public PedidoProductEntity(ProductEntity productEntity, Integer cantidad, PedidoEntity pedidoEntity) {
        this.productEntity = productEntity;
        this.cantidad = cantidad;
        this.pedidoEntity = pedidoEntity;
    }

    public Integer getIdPP() {
        return idPP;
    }

    public void setIdPP(Integer idPP) {
        this.idPP = idPP;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public PedidoEntity getPedidoEntity() {
        return pedidoEntity;
    }

    public void setPedidoEntity(PedidoEntity pedidoEntity) {
        this.pedidoEntity = pedidoEntity;
    }
    
    //metodo que retorna el sub total de cada fila
    public BigDecimal getTotalPrice(){
        return this.productEntity.getPrice().multiply(BigDecimal.valueOf(cantidad));
    }
}
