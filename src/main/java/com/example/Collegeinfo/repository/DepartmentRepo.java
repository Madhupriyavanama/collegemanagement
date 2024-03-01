package com.example.Collegeinfo.repository;

import com.example.Collegeinfo.model.Department; // Assuming Department is your entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    List<Department> findByCollegeName(String collegeName);

    Department findByName(String name);
}

