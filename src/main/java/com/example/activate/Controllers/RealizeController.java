package com.example.activate.Controllers;

import com.example.activate.Entities.Realize;
import com.example.activate.Services.RealizeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/realize")
public class RealizeController {
    private final RealizeService realizePhaseService;

    @PostMapping("/add")
    public Realize addEntity(@RequestBody Realize entity) {
        return realizePhaseService.saveEntity(entity);
    }

    @PutMapping("/update/{id}")
    public Realize updateEntity(@PathVariable("id") String id, @RequestBody Realize entity) {
        return realizePhaseService.updateEntity(id, entity);
    }

    @GetMapping("/retrieve-all")
    public List<Realize> getAllEntities() {
        return realizePhaseService.getAllEntities();
    }

    @GetMapping("/retrieve/{id}")
    public Realize getEntityById(@PathVariable("id") String id) {
        return realizePhaseService.getEntityById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable("id") String id) {
        realizePhaseService.deleteEntity(id);
    }
}
