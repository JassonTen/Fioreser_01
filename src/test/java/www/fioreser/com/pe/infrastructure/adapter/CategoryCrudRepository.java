package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
    
}
