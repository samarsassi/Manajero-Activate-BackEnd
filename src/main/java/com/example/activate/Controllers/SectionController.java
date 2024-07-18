package com.example.activate.Controllers;

import com.example.activate.Entities.Section;
import com.example.activate.Services.SectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/sections")
public class SectionController {
    private final SectionService sectionService;

    @PostMapping("/add")
    public Section addSection(@RequestBody Section section) {
        return sectionService.saveSection(section);
    }

    @PutMapping("/update")
    public Section updateSection(@RequestBody Section section) {
        return sectionService.updateSection(section);
    }

    @GetMapping("/retrieve-all")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/retrieve/{id}")
    public Section getSectionById(@PathVariable("id") String id) {
        return sectionService.getSectionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSection(@PathVariable("id") String id) {
        sectionService.deleteSection(id);
    }
}