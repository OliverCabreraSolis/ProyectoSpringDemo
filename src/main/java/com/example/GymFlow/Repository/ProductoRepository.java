package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.Producto;
import com.example.GymFlow.Model.Producto.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByTipo(Tipo tipo);
    List<Producto> findByDisponible(Boolean disponible);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}