package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.Usuario;
import com.example.GymFlow.Model.Usuario.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar por correo
    Optional<Usuario> findByCorreo(String correo);

    // Buscar por rol
    List<Usuario> findByRol(Rol rol);

    // Buscar por nombre que contenga texto (ignorar mayúsculas/minúsculas)
    List<Usuario> findByNombreContainingIgnoreCase(String texto);

    // Verificar existencia por correo
    boolean existsByCorreo(String correo);
}
