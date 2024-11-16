package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;
/**
 *
 * @author FENIX
 */
@Entity
@Table(name = "Stock")
public class StockEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSt;
    private String Descripcion;
    private Integer Ingreso;
    private Integer Salida;
    private Integer Balanceo;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public StockEntity() {
    }

    public StockEntity(Integer idSt, String Descripcion, Integer Ingreso, Integer Salida, Integer Balanceo, ProductEntity productEntity) {
        this.idSt = idSt;
        this.Descripcion = Descripcion;
        this.Ingreso = Ingreso;
        this.Salida = Salida;
        this.Balanceo = Balanceo;
        this.productEntity = productEntity;
    }

    public Integer getIdSt() {
        return idSt;
    }

    public void setIdSt(Integer idSt) {
        this.idSt = idSt;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getIngreso() {
        return Ingreso;
    }

    public void setIngreso(Integer Ingreso) {
        this.Ingreso = Ingreso;
    }

    public Integer getSalida() {
        return Salida;
    }

    public void setSalida(Integer Salida) {
        this.Salida = Salida;
    }

    public Integer getBalanceo() {
        return Balanceo;
    }

    public void setBalanceo(Integer Balanceo) {
        this.Balanceo = Balanceo;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    
    
}
