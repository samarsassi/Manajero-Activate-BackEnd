package com.example.activate.Controllers;

import com.example.activate.Entities.Configuration;
import com.example.activate.Services.ConfigurationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;
    @PostMapping("/addConfiguration")
    public Configuration addConfiguration(@RequestBody Configuration configuration) {
        return configurationService.createConfiguration(configuration);
    }

    @PutMapping("/updateConfiguration/{id}")
    public Configuration updateConfiguration(@PathVariable("id") String id, @RequestBody Configuration configuration) {
        return configurationService.updateConfiguration(id, configuration);
    }

    @GetMapping("/retrieve-all")
    public List<Configuration> getAllConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @GetMapping("/retrieve-all/{id}")
    public Configuration getConfigurationById(@PathVariable("id") String id) {
        return configurationService.getConfigurationById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConfiguration(@PathVariable("id") String id) {
        configurationService.deleteConfiguration(id);
    }

}
