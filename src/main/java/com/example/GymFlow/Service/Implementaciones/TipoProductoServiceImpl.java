package com.example.GymFlow.Service.Implementaciones;

import com.example.GymFlow.Model.TipoProducto;
import com.example.GymFlow.Repository.TipoProductoRepository;
import com.example.GymFlow.Service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoProductoServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    public List<TipoProducto> obtenerTodos() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public Optional<TipoProducto> obtenerPorId(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    @Override
    public Optional<TipoProducto> obtenerPorNombre(String nombre) {
        return tipoProductoRepository.findByNombreTipo(nombre);
    }

    @Override
    public List<TipoProducto> buscarPorNombre(String nombre) {
        return tipoProductoRepository.findByNombreTipoContainingIgnoreCase(nombre);
    }

    @Override
    public TipoProducto crear(TipoProducto tipoProducto) {
        if (tipoProductoRepository.existsByNombreTipo(tipoProducto.getNombreTipo())) {
            throw new RuntimeException("El tipo de producto ya existe");
        }
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
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

    @Override
    public void eliminar(Integer id) {
        if (!tipoProductoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de producto no encontrado");
        }
        tipoProductoRepository.deleteById(id);
    }
}
