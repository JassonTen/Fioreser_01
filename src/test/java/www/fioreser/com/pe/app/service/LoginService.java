package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioType;

/**
 *
 * @author FENIX
 */
public class LoginService {
    
    private final UsuarioService usuarioService;

    public LoginService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    //retorna true si encuentra el user
    public boolean existeUsuario(String correo){
        try {
            UsuarioEntity user = usuarioService.findByCorreo(correo);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    //obtenemos el id del usuario
    public Integer getUsuarioId(String correo){
        try{
            return usuarioService.findByCorreo(correo).getIdUs();
        }catch (Exception e){
            return 0;
        }
    }
     //obtener tipo de usuario
    public UsuarioType getUsuarioType(String correo){
        return usuarioService.findByCorreo(correo).getTipoUsuario();
    }
     //obtenemos el user por email
    public UsuarioEntity getusuario(String correo){
        try{
            return usuarioService.findByCorreo(correo);
        }catch (Exception e){
            return new UsuarioEntity();
        }
    }
    //obtenemos el user por id
    public UsuarioEntity getUsuario(Integer id){
        try{
            return usuarioService.findById(id);
        }catch (Exception e){
            return new UsuarioEntity();
        }
    }
    
}
