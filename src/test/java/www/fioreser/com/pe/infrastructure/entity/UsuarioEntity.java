package www.fioreser.com.pe.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author FENIX
 */
@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUs;

    private String nombres;
    private String correo;
    private String contraseña;
    private String celular;
    private String direccion;
    private LocalDateTime Fechacreada;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "UsuarioType")
    private UsuarioType tipoUsuario;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer idUs, String nombres, String correo, String contraseña, String celular, String direccion, LocalDateTime Fechacreada, UsuarioType tipoUsuario) {
        this.idUs = idUs;
        this.nombres = nombres;
        this.correo = correo;
        this.contraseña = contraseña;
        this.celular = celular;
        this.direccion = direccion;
        this.Fechacreada = Fechacreada;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechacreada() {
        return Fechacreada;
    }

    public void setFechacreada(LocalDateTime Fechacreada) {
        this.Fechacreada = Fechacreada;
    }

    public UsuarioType getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioType tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
}
