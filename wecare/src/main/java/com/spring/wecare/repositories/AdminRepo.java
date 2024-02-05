package com.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.wecare.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);
}
