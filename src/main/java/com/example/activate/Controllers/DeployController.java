package com.example.activate.Controllers;

import com.example.activate.Entities.DeployPhase;
import com.example.activate.Services.DeployService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

@AllArgsConstructor
@RequestMapping("api/DeployPhase")
public class DeployController {
    private final DeployService DeployService;

    @PostMapping("/addDeploy")
    public DeployPhase addDeploy(@RequestBody DeployPhase t) {
        return DeployService.saveEntity(t);
    }

    @PutMapping("/UpdateDeploy")
    public DeployPhase UpdateDeploy(@RequestBody DeployPhase t) {
        return DeployService.EditEntity(t);
    }

    @GetMapping("/retrieve-all")
    public List<DeployPhase> getdeploy() {
        return DeployService.GetALLEntity();
    }

    @GetMapping("/retrieve-all/{DeployPhase-id}")
    public DeployPhase retievedeploy(@PathVariable("DeployPhase-id") String id) {
        return DeployService.GetEntity(id);
    }

    @DeleteMapping("/Delete/{DeployPhase-id}")
    public void Deletedeploy(@PathVariable("DeployPhase-id") String id) {
        DeployService.DeleteEntity(id);
    }
}
