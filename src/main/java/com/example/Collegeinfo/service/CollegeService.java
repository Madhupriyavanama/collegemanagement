package com.example.Collegeinfo.service;

import com.example.Collegeinfo.model.College;
import com.example.Collegeinfo.model.Department;
import com.example.Collegeinfo.model.Faculty;
import com.example.Collegeinfo.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;

    public College addCollege(College college) {
        return collegeRepo.save(college);
    }

    public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepo.findById(id).orElse(null);
    }

    public College getCollegeByName(String name) {
        return collegeRepo.findByName(name);
    }

    public College updateCollegeName(Long id, College college) {
        College existingCollege = collegeRepo.findById(id).orElse(null);
        if (existingCollege != null) {
            existingCollege.setName(college.getName());
            return collegeRepo.save(existingCollege);
        }
        return null;
    }

    public void deleteCollegeById(Long id) {
        collegeRepo.deleteById(id);
    }

    public List<Department> getDepartmentsByCollegeId(Long id) {

        return null;
    }

    public List<Faculty> getFacultiesByCollegeId(Long id) {

        return null;
    }
}
