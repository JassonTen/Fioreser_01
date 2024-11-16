package www.fioreser.com.pe.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;
/**
 *
 * @author FENIX
 */
public class RegisterService {
    
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }
    
    public void register(UsuarioEntity user){
        if (usuarioService.existsByCorreo(user.getCorreo())) {
            throw new IllegalArgumentException("El usuario ya existe con ese email");
        }
        user.setContraseña(passwordEncoder.encode(user.getContraseña()));
        usuarioService.createUser(user);
    }
    
}
