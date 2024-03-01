package com.example.Collegeinfo.service;

import com.example.Collegeinfo.model.Department;
import com.example.Collegeinfo.model.Faculty;
import com.example.Collegeinfo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department addDepartment(Department department) {
        return (Department) departmentRepo.save(department);
    }

    public List getDepartmentsByCollegeName(String collegeName) {
        return departmentRepo.findByCollegeName(collegeName);
    }

    public Department assignFacultyToDepartment(Long facultyId, Long departmentId) {
        Department department = (Department) departmentRepo.findById(departmentId).orElse(null);
        if (department != null) {
            Faculty faculty = new Faculty();
            faculty.setId(facultyId);
            department.getFaculties().add(faculty);
            return (Department) departmentRepo.save(department);
        }
        return null;
    }


    public Department assignHodToDepartment(Long hodId, Long departmentId) {
        Department department = (Department) departmentRepo.findById(departmentId).orElse(null);
        if (department != null) {
            Faculty hod = new Faculty();
            hod.setId(hodId);
            department.setHod(hod);
            return (Department) departmentRepo.save(department);
        }
        return null;
    }


    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        Department department = (Department) departmentRepo.findByName(departmentName);
        return department != null ? department.getFaculties() : null;
    }


    public Faculty getHodByDepartmentName(String departmentName) {
        Department department = (Department) departmentRepo.findByName(departmentName);
        return department != null ? department.getHod() : null;
    }

    public Department updateDepartment(Long id, Department department) {

        return department;
    }

    public void deleteDepartmentById(Long id) {

    }

    public Department getDepartmentById(Long id) {

        return null;
    }
}
