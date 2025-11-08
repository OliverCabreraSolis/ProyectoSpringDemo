package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
    Optional<TipoProducto> findByNombreTipo(String nombreTipo);
    boolean existsByNombreTipo(String nombreTipo);
    List<TipoProducto> findByNombreTipoContainingIgnoreCase(String nombreTipo);
}