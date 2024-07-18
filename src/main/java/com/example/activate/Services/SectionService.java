package com.example.activate.Services;

import com.example.activate.Entities.Section;
import com.example.activate.Repositories.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService implements ISectionService {
    private final SectionRepository sectionRepository;

    public Section saveSection(Section section) {
        return sectionRepository.insert(section);
    }

    public Section updateSection(Section section) {
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(String id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public void deleteSection(String id) {
        sectionRepository.deleteById(id);
    }
}
