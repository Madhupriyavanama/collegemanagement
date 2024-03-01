package com.example.Collegeinfo.repository;

import com.example.Collegeinfo.model.Faculty; // Assuming Faculty is your entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {

    List<Faculty> findByCollegeName(String collegeName);

    List<Faculty> findByDepartmentName(String departmentName);

    Faculty findHODByDepartmentName(String departmentName);
}
