package www.fioreser.com.pe.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.*;
import org.springframework.web.multipart.MultipartFile;
import www.fioreser.com.pe.app.repository.ProductRepository;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public class ProductService {
    
    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);
    
    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }
    
     public Iterable<ProductEntity> getProducts() {
       return productRepository.getProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UsuarioEntity usuarioEntity) {
      return productRepository.getProductsByUser(usuarioEntity);
    }

    public ProductEntity getProductById(Integer id) {
      return productRepository.getProductById(id);
    }

    public ProductEntity saveProduct(ProductEntity productEntity,MultipartFile multipartFile) throws IOException {
        if (productEntity.getIdPr()== null) {
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUs(1);
            productEntity.setFechacreado(LocalDateTime.now());
            productEntity.setFechaactualizada(LocalDateTime.now());
            productEntity.setUsuarioEntity(user);
            productEntity.setImagen(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(productEntity);
        } else {
            ProductEntity productDB = productRepository.getProductById(productEntity.getIdPr());
            log.info("product {}", productDB);

            //actualizar la imagen del producto
            if (multipartFile.isEmpty()) {
                productEntity.setImagen(productDB.getImagen());
            } else {
                if (!productDB.getImagen().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImagen());
                }
                productEntity.setImagen(uploadFile.upload(multipartFile));
            }

            productEntity.setCode(productDB.getCode());
            productEntity.setUsuarioEntity(productDB.getUsuarioEntity());
            productEntity.setFechacreado(productDB.getFechacreado());
            productEntity.setFechaactualizada(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }

    public boolean deleteProductById(Integer id) {
      return productRepository.deleteProductById(id);
    }
    
}
