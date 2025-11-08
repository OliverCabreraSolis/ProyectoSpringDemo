package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    Optional<TipoProducto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<TipoProducto> findByNombreContainingIgnoreCase(String nombre);
}