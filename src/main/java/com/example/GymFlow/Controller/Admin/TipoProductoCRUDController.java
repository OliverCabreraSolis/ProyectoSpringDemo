package com.example.GymFlow.Controller.Admin;

import com.example.GymFlow.Model.Producto;
import com.example.GymFlow.Model.TipoProducto;
import com.example.GymFlow.Service.ProductoService;
import com.example.GymFlow.Service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("admin/productosCRUD")
public class TipoProductoCRUDController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public String listar(@RequestParam(required = false) Integer idTipo, Model model) {
        List<Producto> productos;

        if (idTipo != null) {
            productos = productoService.obtenerPorTipo(idTipo);
        } else {
            productos = productoService.obtenerTodos();
        }

        List<TipoProducto> tipos = tipoProductoService.obtenerTodos();

        model.addAttribute("productos", productos);
        model.addAttribute("tipos", tipos);
        model.addAttribute("productoEditar", new Producto());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto,
                          @RequestParam Integer idTipo,
                          RedirectAttributes redirectAttributes) {
        try {
            TipoProducto tipo = tipoProductoService.obtenerPorId(idTipo)
                    .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
            producto.setTipoProducto(tipo);

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
    public String editar(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Producto producto = productoService.obtenerPorId(id)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            List<Producto> productos = productoService.obtenerTodos();
            List<TipoProducto> tipos = tipoProductoService.obtenerTodos();

            model.addAttribute("productos", productos);
            model.addAttribute("tipos", tipos);
            model.addAttribute("productoEditar", producto);
            return "productos";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error: " + e.getMessage());
            return "redirect:/productos";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @ModelAttribute Producto producto,
                             @RequestParam Integer idTipo,
                             RedirectAttributes redirectAttributes) {
        try {
            TipoProducto tipo = tipoProductoService.obtenerPorId(idTipo)
                    .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
            producto.setTipoProducto(tipo);

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
    public String eliminar(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            productoService.eliminar(id);
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
        List<TipoProducto> tipos = tipoProductoService.obtenerTodos();

        model.addAttribute("productos", productos);
        model.addAttribute("tipos", tipos);
        model.addAttribute("productoEditar", new Producto());
        return "productos";
    }
}