package com.example.activate.Services;

import com.example.activate.Entities.Configuration;
import com.example.activate.Repositories.ConfigurationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationService implements IConfigurationService {
    private ConfigurationRepository configurationRepository;


    public Configuration createConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public Configuration updateConfiguration(String id, Configuration configuration) {
        Optional<Configuration> existingConfigurationOptional = configurationRepository.findById(id);
        if (existingConfigurationOptional.isPresent()) {
            Configuration existingConfiguration = existingConfigurationOptional.get();
            existingConfiguration.setName(configuration.getName());
            existingConfiguration.setDescription(configuration.getDescription());
            existingConfiguration.setStatus(configuration.getStatus());
            existingConfiguration.setCreatedDate(configuration.getCreatedDate());
            existingConfiguration.setUpdatedDate(configuration.getUpdatedDate());
            return configurationRepository.save(existingConfiguration);
        } else {
            throw new RuntimeException("Configuration not found with id: " + id);
        }
    }

    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }

    public Optional<Configuration> getConfigurationById(String id) {
        return configurationRepository.findById(id);
    }

    public void deleteConfiguration(String id) {
        configurationRepository.deleteById(id);
    }

    public Configuration GetEntity(String id) {
        return configurationRepository.findById(id).orElse(null);
    }

    public void DeleteEntity(String id) {
        configurationRepository.deleteById(id);
    }
}
