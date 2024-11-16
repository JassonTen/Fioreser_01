package www.fioreser.com.pe.infrastructure.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import www.fioreser.com.pe.app.repository.CategoryRepository;
import www.fioreser.com.pe.app.repository.PedidoProductRepository;
import www.fioreser.com.pe.app.repository.PedidoRepository;
import www.fioreser.com.pe.app.repository.ProductRepository;
import www.fioreser.com.pe.app.repository.StockRepository;
import www.fioreser.com.pe.app.repository.UsuarioRepository;
import www.fioreser.com.pe.app.service.CarritoService;
import www.fioreser.com.pe.app.service.CategoryService;
import www.fioreser.com.pe.app.service.LoginService;
import www.fioreser.com.pe.app.service.LogoutService;
import www.fioreser.com.pe.app.service.PedidoProductService;
import www.fioreser.com.pe.app.service.PedidoService;
import www.fioreser.com.pe.app.service.ProductService;
import www.fioreser.com.pe.app.service.RegisterService;
import www.fioreser.com.pe.app.service.StockService;
import www.fioreser.com.pe.app.service.UploadFile;
import www.fioreser.com.pe.app.service.UsuarioService;
import www.fioreser.com.pe.app.service.ValidarStock;

/**
 *
 * @author FENIX
 */
@Configuration
public class BeanConfig {
    
    @Bean
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository){
        return new UsuarioService(usuarioRepository);
    }
    
    @Bean
   public UploadFile uploadFile(){
       return new UploadFile();
   }
    @Bean
    public ProductService productService (ProductRepository productRepository,UploadFile uploadFile){
        return new ProductService(productRepository,uploadFile);
    }
    
    @Bean
    public CategoryService categoryService (CategoryRepository categoryRepository){
        return  new CategoryService(categoryRepository);
    }
    
    @Bean
    public PedidoService pedidoService (PedidoRepository pedidoRepository){
        return new PedidoService(pedidoRepository);
    }
    
    @Bean
    public PedidoProductService pedidoProductService (PedidoProductRepository  pedidoProductRepository){
        return new PedidoProductService(pedidoProductRepository);
    }
     
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CarritoService carritoService(){
        return new CarritoService();
    }
     @Bean
   public StockService stockService(StockRepository stockRepository){
      return new StockService(stockRepository);
   }
     @Bean
    public ValidarStock validarStock(StockService stockService) {
        return new ValidarStock(stockService);
    }
    
    @Bean
    public LoginService loginService(UsuarioService usuarioService){
        return new LoginService(usuarioService);
    }
    @Bean
    public LogoutService logoutService(){
        return  new LogoutService();
    } 
    @Bean
    public RegisterService registrationService(UsuarioService usuarioService, PasswordEncoder passwordEncoder){
        return  new RegisterService(usuarioService, passwordEncoder);
    }
    
}
