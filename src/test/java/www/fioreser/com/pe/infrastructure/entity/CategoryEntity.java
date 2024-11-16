package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;

/**
 *
 * @author FENIX
 */
@Entity
@Table(name="Category")
public class CategoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCa;
    private String name;
    private String status;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer idCa, String name, String status) {
        this.idCa = idCa;
        this.name = name;
        this.status = status;
    }

    public Integer getIdCa() {
        return idCa;
    }

    public void setIdCa(Integer idCa) {
        this.idCa = idCa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
