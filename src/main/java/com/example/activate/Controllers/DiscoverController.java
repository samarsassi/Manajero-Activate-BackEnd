package com.example.activate.Controllers;

import com.example.activate.Entities.DiscoverPhase;
import com.example.activate.Services.DiscoverService;
import com.example.activate.Services.DiscoverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/DiscoverPhase")
public class DiscoverController {
    private final DiscoverService DiscoverService;

    @PostMapping("/addDiscover")
    public DiscoverPhase addDiscover(@RequestBody DiscoverPhase t) {
        return DiscoverService.saveEntity(t);
    }

    @PutMapping("/UpdateDiscover")
    public DiscoverPhase UpdateDiscover(@RequestBody DiscoverPhase t) {
        return DiscoverService.EditEntity(t);
    }

    @GetMapping("/retrieve-all")
    public List<DiscoverPhase> getdiscover() {
        return DiscoverService.GetALLEntity();
    }

    @GetMapping("/retrieve-all/{DiscoverPhase-id}")
    public DiscoverPhase retievediscover(@PathVariable("DiscoverPhase-id") String id) {
        return DiscoverService.GetEntity(id);
    }

    @DeleteMapping("/Delete/{DiscoverPhase-id}")
    public void Deletediscover(@PathVariable("DiscoverPhase-id") String id) {
        DiscoverService.DeleteEntity(id);
    }
}
