package com.example.Collegeinfo.controller;

import com.example.Collegeinfo.model.Faculty;
import com.example.Collegeinfo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("/college/{collegeName}")
    public List<Faculty> getFacultiesByCollegeName(@PathVariable String collegeName) {
        return facultyService.getFacultiesByCollegeName(collegeName);
    }

    @GetMapping("/department/{departmentName}")
    public List<Faculty> getFacultiesByDepartmentName(@PathVariable String departmentName) {
        return facultyService.getFacultiesByDepartmentName(departmentName);
    }

    @PostMapping("/assign")
    public Faculty assignFacultyToDepartment(@RequestParam Long facultyId, @RequestParam Long departmentId) {
        return facultyService.assignFacultyToDepartment(facultyId, departmentId);
    }

    @GetMapping("/department/{departmentName}/hod")
    public Faculty getHODByDepartmentName(@PathVariable String departmentName) {
        return facultyService.getHODByDepartmentName(departmentName);
    }

    // Other faculty-related endpoints
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFacultyById(@PathVariable Long id) {
        facultyService.deleteFacultyById(id);
    }
}
