package com.example.GymFlow.Service;

import com.example.GymFlow.Model.Producto;
import com.example.GymFlow.Model.TipoProducto;
import com.example.GymFlow.Repository.ProductoRepository;
import com.example.GymFlow.Repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerPorTipo(Integer idTipo) {
        return productoRepository.findByTipoProducto_IdTipo(idTipo);
    }

    public List<Producto> obtenerPorNombreTipo(String nombreTipo) {
        return productoRepository.findByTipoProducto_NombreTipo(nombreTipo);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setTipoProducto(productoActualizado.getTipoProducto());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setCantidad(productoActualizado.getCantidad());

        return productoRepository.save(producto);
    }

    public void eliminar(Integer id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }
}