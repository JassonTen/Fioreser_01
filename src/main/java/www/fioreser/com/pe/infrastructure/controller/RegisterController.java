package www.fioreser.com.pe.infrastructure.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.fioreser.com.pe.app.service.RegisterService;
import www.fioreser.com.pe.app.service.UsuarioService;
import www.fioreser.com.pe.infrastructure.dto.UsuarioDto;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UsuarioService usuarioService;

    public RegisterController(RegisterService registerService, UsuarioService usuarioService) {
        this.registerService = registerService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("usuarioDto", new UsuarioDto());
        return "register";
    }

    @PostMapping
    public String registerUser(@Valid UsuarioDto usuarioDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // Verificar si hay errores de validación en el formulario
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(
                    e -> log.info("Error {}", e.getDefaultMessage())
            );
            redirectAttributes.addFlashAttribute("error", "Hay errores en el formulario. Revisa los campos e inténtalo de nuevo.");
            return "register";
        }

        // Verificar si el correo ya existe
        if (usuarioService.existsByCorreo(usuarioDto.getCorreo())) {
            redirectAttributes.addFlashAttribute("error", "El correo ya está en uso. Intenta con otro.");
            return "redirect:/register";
        }

        // Registrar el usuario si no hay errores
        registerService.register(usuarioDto.usuarioDtoToUsuario());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/login";
    }

}
