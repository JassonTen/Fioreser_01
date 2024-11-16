package www.fioreser.com.pe.infrastructure.controller;

import jakarta.validation.Valid;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.fioreser.com.pe.app.service.RegisterService;
import www.fioreser.com.pe.app.service.UsuarioService;
import www.fioreser.com.pe.infrastructure.dto.UsuarioDto;

/**
 *
 * @author ENIX
 */
@Controller
@RequestMapping("/aD1M9c2kQW3x8I4Nb5m7A6dLzJp")
public class shhhController {
    
    private final RegisterService registerService;
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UsuarioService usuarioService;

    public shhhController(RegisterService registerService, UsuarioService usuarioService) {
        this.registerService = registerService;
        this.usuarioService = usuarioService;
    }
    
    @GetMapping
    public String registerADMI(Model model){
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "aD1M9c2kQW3x8I4Nb5m7A6dLzJp";
    }
    
    @PostMapping
    public String registerAdmin(@Valid UsuarioDto usuarioDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // Verificar si hay errores de validación en el formulario
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(
                    e -> log.info("Error {}", e.getDefaultMessage())
            );
            redirectAttributes.addFlashAttribute("error", "Hay errores en el formulario. Revisa los campos e inténtalo de nuevo.");
            return "aD1M9c2kQW3x8I4Nb5m7A6dLzJp";
        }

        // Verificar si el correo ya existe
        if (usuarioService.existsByCorreo(usuarioDto.getCorreo())) {
            redirectAttributes.addFlashAttribute("error", "El correo ya está en uso. Intenta con otro.");
            return "redirect:/aD1M9c2kQW3x8I4Nb5m7A6dLzJp";
        }

        // Registrar el usuario si no hay errores
        registerService.register(usuarioDto.usuarioDtoToAdmin());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/login";
    }
    
}
