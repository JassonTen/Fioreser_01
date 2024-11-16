package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.app.repository.UsuarioRepository;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public class UsuarioService {
    //Intancia del user repository
    private final UsuarioRepository usuarioRepository;

    //constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    //metodos
    public UsuarioEntity createUser(UsuarioEntity usuarioEntity) {
        return usuarioRepository.createUsuario(usuarioEntity);
    }

    public UsuarioEntity findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public UsuarioEntity findById(Integer idUs) {
        return usuarioRepository.findById(idUs);
    }
    
    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }
}
