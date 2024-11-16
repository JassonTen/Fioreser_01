package www.fioreser.com.pe.app.repository;

import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
public interface ProductRepository {
    
    Iterable<ProductEntity> getProducts();
    Iterable<ProductEntity> getProductsByUser(UsuarioEntity usuarioEntity);
    ProductEntity getProductById(Integer idPr);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer idPr);
    
}
