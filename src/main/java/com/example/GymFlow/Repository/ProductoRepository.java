package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.GymFlow.Model.TipoProducto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Buscar por tipo de producto (relación con TipoProducto)
    List<Producto> findByTipoProducto(TipoProducto tipoProducto);

    // Buscar por ID de tipo
    List<Producto> findByTipoProducto_IdTipo(Integer idTipo);

    // Buscar por nombre de tipo
    List<Producto> findByTipoProducto_NombreTipo(String nombreTipo);

    // Buscar por nombre del producto
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Buscar productos con cantidad mayor a cero
    List<Producto> findByCantidadGreaterThan(java.math.BigDecimal cantidad);
}