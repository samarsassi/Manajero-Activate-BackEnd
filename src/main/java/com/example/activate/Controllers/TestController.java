package com.example.activate.Controllers;

import com.example.activate.Entities.test;
import com.example.activate.Services.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/Test")
public class TestController {
    private final TestService testService;

    @PostMapping("/addTest")
    public test addTest(@RequestBody test t) {
        return testService.saveEntity(t);
    }

    @PutMapping("/Updatetest")
    public test Updatetest(@RequestBody test t) {
        return testService.EditEntity(t);
    }

    @GetMapping("/retrieve-all")
    public List<test> gettest() {
        return testService.GetALLEntity();
    }

    @GetMapping("/retrieve-all/{test-id}")
    public test retievetest(@PathVariable("test-id") String id) {
        return testService.GetEntity(id);
    }

    @DeleteMapping("/Delete/{test-id}")
    public void Deletetest(@PathVariable("test-id") String id) {
        testService.DeleteEntity(id);
    }
}
