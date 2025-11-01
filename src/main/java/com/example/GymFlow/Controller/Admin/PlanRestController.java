package com.example.GymFlow.Controller.Admin;

import com.example.GymFlow.Model.Plan;
import com.example.GymFlow.Service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin/planes/api")
public class PlanRestController {

    private final PlanService planService;

    public PlanRestController(PlanService planService) {
        this.planService = planService;
    }

    // Crear nuevo plan
    @PostMapping
    public ResponseEntity<Plan> crearPlan(@RequestBody Plan plan) {
        Plan nuevo = planService.guardar(plan);
        return ResponseEntity.ok(nuevo);
    }

    // Actualizar plan existente
    @PutMapping("/{id}")
    public ResponseEntity<Plan> actualizarPlan(@PathVariable Long id, @RequestBody Plan planActualizado) {
        Optional<Plan> planOpt = planService.obtenerPorId(id);
        if (planOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Plan plan = planOpt.get();
        plan.setDuracion(planActualizado.getDuracion());
        plan.setPrecio(planActualizado.getPrecio());
        plan.setDescripcion(planActualizado.getDescripcion());
        Plan actualizado = planService.guardar(plan);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar plan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlan(@PathVariable Long id) {
        planService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
