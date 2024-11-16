package www.fioreser.com.pe.infrastructure.servicios;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import www.fioreser.com.pe.app.service.LoginService;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;
/**
 *
 * @author FENIX
 */
@Service
public class UsuarioDetallesServiceImpl implements UserDetailsService {
    
    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;

    @Autowired
    private HttpSession httpSession;

    public UsuarioDetallesServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUsuarioId(username);
        if (idUser != USER_NOT_FOUND) {
            UsuarioEntity user = loginService.getusuario(username);
            httpSession.setAttribute("iduser", user.getIdUs());
            httpSession.setAttribute("nombres", user.getNombres());
            httpSession.setAttribute("correo", user.getCorreo());
            return org.springframework.security.core.userdetails.User.builder().username(user.getNombres()).password(user.getContraseña()).roles(user.getTipoUsuario().name()).build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado ");
        }

    }
    
}
