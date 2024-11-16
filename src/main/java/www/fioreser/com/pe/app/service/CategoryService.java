package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.app.repository.CategoryRepository;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    
    public Iterable<CategoryEntity>  getCategory(){
        return categoryRepository.getCategory();
    }
   
    public CategoryEntity getCategoryById(Integer idCa){
        return categoryRepository.getCategoryById(idCa);
    }
    public CategoryEntity guardarCategory(CategoryEntity categoryEntity){
        return categoryRepository.guardarCategory(categoryEntity);
    }
    public boolean deleteCategoryById(Integer idCa){
        return categoryRepository.deleteCategoryById(idCa);
    }
    
}
