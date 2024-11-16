package www.fioreser.com.pe.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import www.fioreser.com.pe.app.repository.CategoryRepository;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryCrudRepository  categoryCrudRepository;

    public CategoryRepositoryImpl(CategoryCrudRepository categoryCrudRepository) {
        this.categoryCrudRepository = categoryCrudRepository;
    }

    @Override
    public Iterable<CategoryEntity> getCategory() {
        return categoryCrudRepository.findAll();
    } 
    @Override
    public CategoryEntity getCategoryById(Integer idCa){
        return categoryCrudRepository.findById(idCa).get(); 
    }
    @Override
    public CategoryEntity guardarCategory(CategoryEntity categoryEntity){
      return categoryCrudRepository.save(categoryEntity);
    }
     
    @Override
    public boolean deleteCategoryById(Integer idCa){
        categoryCrudRepository.deleteById(idCa);
        return true;
    }
    
}
