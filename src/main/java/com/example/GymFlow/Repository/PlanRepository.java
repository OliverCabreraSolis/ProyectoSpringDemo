package com.example.GymFlow.Repository;

import com.example.GymFlow.Model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByDuracion(String duracion);
}