package www.fioreser.com.pe.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.fioreser.com.pe.app.service.CategoryService;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {
  private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String showCategoryList(Model model) {
        model.addAttribute("category", categoryService.getCategory());
        return "admin/category";
    }

    @GetMapping("/create")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "admin/category";
    }

    @PostMapping("/save")
    public String saveCategoryL(@ModelAttribute("category") CategoryEntity categoryEntity) {
        categoryService.guardarCategory(categoryEntity);
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{idtf}")
    public String editCategoryForm(@PathVariable("idCa") Integer idCa, Model model) {
        CategoryEntity category = categoryService.getCategoryById(idCa);
        model.addAttribute("category", category);
        return "admin/category";
    }

    @PostMapping("/update")
    public String updateCategoryL(@ModelAttribute("category") CategoryEntity categoryEntity) {
        categoryService.guardarCategory(categoryEntity);
        return "redirect:/admin/category";
    }

    @GetMapping("/delete/{idCa}")
    public String deleteCategoryL(@PathVariable("idCa") Integer idCa) {
        categoryService.deleteCategoryById(idCa);
        return "redirect:/admin/category";
    }    
}
