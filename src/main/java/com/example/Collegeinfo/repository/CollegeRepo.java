package com.example.Collegeinfo.repository;

import com.example.Collegeinfo.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {
    College findByName(String name);
}


