package com.example.GymFlow.Controller.Admin;

import com.example.GymFlow.Model.Usuario;
import com.example.GymFlow.Model.Usuario.Rol;
import com.example.GymFlow.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("admin/usuario")
public class UsuarioCRUDController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(@RequestParam(required = false) String rol, Model model) {
        List<Usuario> usuarios;
        if (rol != null && !rol.isEmpty()) {
            usuarios = usuarioService.obtenerPorRol(Rol.valueOf(rol));
        } else {
            usuarios = usuarioService.obtenerTodos();
        }
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", Rol.values());
        model.addAttribute("usuarioEditar", new Usuario());
        return "admin/usuariosCRUD";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.crear(usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario creado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.obtenerPorId(Math.toIntExact(id))
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            List<Usuario> usuarios = usuarioService.obtenerTodos();
            model.addAttribute("usuarios", usuarios);
            model.addAttribute("roles", Rol.values());
            model.addAttribute("usuarioEditar", usuario);
            return "admin/usuariosCRUD";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.actualizar(Math.toIntExact(id), usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario actualizado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.eliminar(Math.toIntExact(id));
            redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String texto, Model model) {
        List<Usuario> usuarios = usuarioService.buscarPorNombre(texto);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", Rol.values());
        model.addAttribute("usuarioEditar", new Usuario());
        return "admin/usuariosCRUD";
    }
}