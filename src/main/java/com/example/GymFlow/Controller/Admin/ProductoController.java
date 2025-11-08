package com.example.GymFlow.Controller.Admin;

import com.example.GymFlow.Model.Producto;
import com.example.GymFlow.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("admin/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listar(@RequestParam(required = false) String tipo, Model model) {
        List<Producto> productos;
        if (tipo != null && !tipo.isEmpty()) {
            productos = productoService.obtenerPorTipo(Tipo.valueOf(tipo));
        } else {
            productos = productoService.obtenerTodos();
        }
        model.addAttribute("productos", productos);
        model.addAttribute("tipos", Tipo.values());
        model.addAttribute("productoEditar", new Producto());
        return "admin/productosCRUD";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
        try {
            productoService.crear(producto);
            redirectAttributes.addFlashAttribute("mensaje", "Producto creado");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Producto producto = productoService.obtenerPorId(id)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            List<Producto> productos = productoService.obtenerTodos();
            model.addAttribute("productos", productos);
            model.addAttribute("tipos", Tipo.values());
            model.addAttribute("productoEditar", producto);
            return "admin/productosCRUD";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            return "redirect:/productos";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
        try {
            productoService.actualizar(id, producto);
            redirectAttributes.addFlashAttribute("mensaje", "Producto actualizado");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            productoService.eliminar(idProducto);
            redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "error");
        }
        return "redirect:/productos";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String texto, Model model) {
        List<Producto> productos = productoService.buscarPorNombre(texto);
        model.addAttribute("productos", productos);
        model.addAttribute("tipos", Tipo.values());
        model.addAttribute("productoEditar", new Producto());
        return "admin/productosCRUD";
    }
}
