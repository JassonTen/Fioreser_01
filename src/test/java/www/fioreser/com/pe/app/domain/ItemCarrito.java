package www.fioreser.com.pe.app.domain;

import java.math.BigDecimal;

/**
 *
 * @author FENIX
 */
public class ItemCarrito {

    private Integer idPrC;
    private String nombrePr;
    private Integer cantidad;
    private BigDecimal precio;

    public BigDecimal getTotalPriceItem() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }

    public ItemCarrito(Integer idPrC, String nombrePr, Integer cantidad, BigDecimal precio) {
        this.idPrC = idPrC;
        this.nombrePr = nombrePr;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdPrC() {
        return idPrC;
    }

    public void setIdPrC(Integer idPrC) {
        this.idPrC = idPrC;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return "ItemCarrito{" + "idPrC=" + idPrC + ", nombrePr=" + nombrePr + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
}
