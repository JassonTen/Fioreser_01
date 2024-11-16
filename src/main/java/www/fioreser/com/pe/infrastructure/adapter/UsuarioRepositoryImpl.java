package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import www.fioreser.com.pe.app.repository.UsuarioRepository;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    
    private final UsuarioCrudRepository usuarioCrudRepository;

    public UsuarioRepositoryImpl(UsuarioCrudRepository usuarioCrudRepository) {
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    @Override
    public UsuarioEntity createUsuario(UsuarioEntity usuarioEntity) {
        return usuarioCrudRepository.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity findByCorreo(String correo) {
        return usuarioCrudRepository.findByCorreo(correo).get();
    }

    @Override
    public UsuarioEntity findById(Integer idUs) {
        return usuarioCrudRepository.findById(idUs).get();
    }    

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioCrudRepository.existsByCorreo(correo);
    }

    
    
}
