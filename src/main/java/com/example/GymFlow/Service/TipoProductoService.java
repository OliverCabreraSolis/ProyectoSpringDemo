package com.example.GymFlow.Service;

import com.example.GymFlow.Model.TipoProducto;
import java.util.List;
import java.util.Optional;

public interface TipoProductoService {

    List<TipoProducto> obtenerTodos();

    Optional<TipoProducto> obtenerPorId(Integer id);

    Optional<TipoProducto> obtenerPorNombre(String nombre);

    List<TipoProducto> buscarPorNombre(String nombre);

    TipoProducto crear(TipoProducto tipoProducto);

    TipoProducto actualizar(Integer id, TipoProducto tipoActualizado);

    void eliminar(Integer id);
}