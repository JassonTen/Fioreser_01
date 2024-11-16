package www.fioreser.com.pe.app.repository;

import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface UsuarioRepository {
    
    //crear un nuevo usuario
    public UsuarioEntity createUsuario(UsuarioEntity usuarioEntity);
    
    public UsuarioEntity findByCorreo(String correo);
    
    public UsuarioEntity findById(Integer idUs);
    
    public boolean existsByCorreo(String correo);
    
}
