package com.example.GymFlow.Service;

import com.gymflow.model.Plan;
import com.gymflow.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> listar() {
        return planRepository.findAll();
    }

    public List<Plan> listarPorDuracion(String duracion) {
        return planRepository.findByDuracion(duracion);
    }

    public Plan guardar(Plan plan) {
        return planRepository.save(plan);
    }

    public void eliminar(Long id) {
        planRepository.deleteById(id);
    }

    public Optional<Plan> obtenerPorId(Long id) {
        return planRepository.findById(id);
    }
}
