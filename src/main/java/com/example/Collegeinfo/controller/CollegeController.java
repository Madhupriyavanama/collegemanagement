package com.example.Collegeinfo.controller;

import com.example.Collegeinfo.model.College;
import com.example.Collegeinfo.model.Department;
import com.example.Collegeinfo.model.Faculty;
import com.example.Collegeinfo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @GetMapping("/{id}/departments")
    public List<Department> getDepartmentsByCollegeId(@PathVariable Long id) {
        return collegeService.getDepartmentsByCollegeId(id);
    }

    @GetMapping("/{id}/faculties")
    public List<Faculty> getFacultiesByCollegeId(@PathVariable Long id) {
        return collegeService.getFacultiesByCollegeId(id);
    }

    @GetMapping("/name/{name}")
    public College getCollegeByName(@PathVariable String name) {
        return collegeService.getCollegeByName(name);
    }

    @PutMapping("/{id}")
    public College updateCollegeName(@PathVariable Long id, @RequestBody College college) {
        return collegeService.updateCollegeName(id, college);
    }

    @DeleteMapping("/{id}")
    public void deleteCollegeById(@PathVariable Long id) {
        collegeService.deleteCollegeById(id);
    }
}
