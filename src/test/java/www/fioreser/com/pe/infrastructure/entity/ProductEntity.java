package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author FENIX
 */
@Entity
@Table(name = "Producto")
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPr;

    private String code;
    private String nombre;
    private String descripcion;
    private String imagen;
    private BigDecimal price;
    private LocalDateTime Fechacreado;
    private LocalDateTime Fechaactualizada;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsuarioEntity usuarioEntity;
    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private CategoryEntity categoryEntity;

    public ProductEntity(Integer idPr, String code, String nombre, String descripcion, String imagen, BigDecimal price, LocalDateTime Fechacreado, LocalDateTime Fechaactualizada, UsuarioEntity usuarioEntity, CategoryEntity categoryEntity) {
        this.idPr = idPr;
        this.code = code;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.price = price;
        this.Fechacreado = Fechacreado;
        this.Fechaactualizada = Fechaactualizada;
        this.usuarioEntity = usuarioEntity;
        this.categoryEntity = categoryEntity;
    }

    public Integer getIdPr() {
        return idPr;
    }

    public void setIdPr(Integer idPr) {
        this.idPr = idPr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getFechacreado() {
        return Fechacreado;
    }

    public void setFechacreado(LocalDateTime Fechacreado) {
        this.Fechacreado = Fechacreado;
    }

    public LocalDateTime getFechaactualizada() {
        return Fechaactualizada;
    }

    public void setFechaactualizada(LocalDateTime Fechaactualizada) {
        this.Fechaactualizada = Fechaactualizada;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public ProductEntity() {
        this.setCode(UUID.randomUUID().toString());
    }
    
}
