package www.fioreser.com.pe.infrastructure.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioType;

/**
 *
 * @author FENIX
 */
public class UsuarioDto {
    @NotBlank (message = "Nombre es requerido")
    private String nombres;
    @Email(message = "Debe ingresar un email valido")
    private String correo;
    @NotBlank (message = "Contraseña es requerido")
    private String contraseña;
    @NotBlank (message = "Celular es requerido")
    @Size(max = 9,min = 9, message = "Ingrese 9 digitos")
    private String celular;
    @NotBlank (message = "Dirección es requerido")
    private String direccion;
    

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
    
    public UsuarioEntity usuarioDtoToUser(){
        return new UsuarioEntity(null, this.getNombres(), this.getCorreo(), this.getContraseña(), this.getCelular(), this.getDireccion(), LocalDateTime.now(), UsuarioType.USER);
    }
    
}
