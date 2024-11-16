package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import www.fioreser.com.pe.app.repository.ProductRepository;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<ProductEntity> getProducts() {
        return productCrudRepository.findAll();
    }

    @Override
    public Iterable<ProductEntity> getProductsByUser(UsuarioEntity usuarioEntity) {
        return productCrudRepository.findByUsuarioEntity(usuarioEntity);
    }

    @Override
    public ProductEntity getProductById(Integer idPr) {
        return productCrudRepository.findById(idPr).get();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productCrudRepository.save(productEntity);
    }

    @Override
    public boolean deleteProductById(Integer idPr) {
        productCrudRepository.deleteById(idPr);
        return true;
    }
    
    

}
