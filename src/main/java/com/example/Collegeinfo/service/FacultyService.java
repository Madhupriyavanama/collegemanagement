package com.example.Collegeinfo.service;

import com.example.Collegeinfo.model.Faculty;
import com.example.Collegeinfo.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        return facultyRepo.findByCollegeName(collegeName);
    }

    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return facultyRepo.findByDepartmentName(departmentName);
    }

    public Faculty assignFacultyToDepartment(Long facultyId, Long departmentId) {
        Faculty faculty = facultyRepo.findById(facultyId).orElse(null);
        if (faculty != null) {
            faculty.setDepartmentId(departmentId);
            return facultyRepo.save(faculty);
        }
        return null;
    }

    public Faculty getHODByDepartmentName(String departmentName) {
        return facultyRepo.findHODByDepartmentName(departmentName);
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepo.findById(id).orElse(null);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepo.findAll();
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existingFaculty = facultyRepo.findById(id).orElse(null);
        if (existingFaculty != null) {
            existingFaculty.setName(faculty.getName());
            // Set other attributes as required
            return facultyRepo.save(existingFaculty);
        }
        return null;
    }

    public void deleteFacultyById(Long id) {
        facultyRepo.deleteById(id);
    }
}
