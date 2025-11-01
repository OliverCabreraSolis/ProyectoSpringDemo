package com.example.GymFlow.Controller.Admin;

import com.gymflow.model.Plan;
import com.gymflow.service.PlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public String listarPlanes(@RequestParam(required = false) String duracion, Model model) {
        List<Plan> planes = (duracion == null || duracion.isEmpty())
                ? planService.listar()
                : planService.listarPorDuracion(duracion);
        model.addAttribute("planes", planes);
        return "admin/planes"; // JSP
    }
}
