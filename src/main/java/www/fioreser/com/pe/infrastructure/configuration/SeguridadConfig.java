package www.fioreser.com.pe.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import www.fioreser.com.pe.infrastructure.servicios.UsuarioDetallesServiceImpl;
import www.fioreser.com.pe.infrastructure.servicios.loginHandler;
/**
 *
 * @author FENIX
 */
@Configuration
@EnableWebSecurity
public class SeguridadConfig {
    
    @Autowired
    private final UsuarioDetallesServiceImpl userDetailService;

    @Autowired
    private loginHandler loginHandler;

    public SeguridadConfig(UsuarioDetallesServiceImpl usuarioDetallesServiceImpl) {
        this.userDetailService = usuarioDetallesServiceImpl;
    }

    //metodo de autentificación
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/cliente/**").hasRole("USER").anyRequest().permitAll())
                .formLogin(form -> form
                .loginPage("/login")
                .successHandler(loginHandler))
                .logout(log -> log
                .logoutSuccessUrl("/close"))
                .build();
    }

    //metodo para encriptar las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
