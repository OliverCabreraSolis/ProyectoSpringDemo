package com.example.GymFlow.Service;

import com.example.GymFlow.Model.TipoProducto;
import com.example.GymFlow.Repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> obtenerTodos() {
        return tipoProductoRepository.findAll();
    }

    public Optional<TipoProducto> obtenerPorId(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    public Optional<TipoProducto> obtenerPorNombre(String nombre) {
        return tipoProductoRepository.findByNombreTipo(nombre);
    }

    public List<TipoProducto> buscarPorNombre(String nombre) {
        return tipoProductoRepository.findByNombreTipoContainingIgnoreCase(nombre);
    }

    public TipoProducto crear(TipoProducto tipoProducto) {
        if (tipoProductoRepository.existsByNombreTipo(tipoProducto.getNombreTipo())) {
            throw new RuntimeException("El tipo de producto ya existe");
        }
        return tipoProductoRepository.save(tipoProducto);
    }

    public TipoProducto actualizar(Integer id, TipoProducto tipoActualizado) {
        TipoProducto tipo = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de producto no encontrado"));

        if (!tipo.getNombreTipo().equals(tipoActualizado.getNombreTipo())
                && tipoProductoRepository.existsByNombreTipo(tipoActualizado.getNombreTipo())) {
            throw new RuntimeException("El nombre del tipo ya existe");
        }

        tipo.setNombreTipo(tipoActualizado.getNombreTipo());
        tipo.setDescripcionProducto(tipoActualizado.getDescripcionProducto());

        return tipoProductoRepository.save(tipo);
    }

    public void eliminar(Integer id) {
        if (!tipoProductoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de producto no encontrado");
        }
        tipoProductoRepository.deleteById(id);
    }
}