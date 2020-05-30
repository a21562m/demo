package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.AppUser;

public interface UserRepository extends JpaRepository<AppUser, String>
{
	
}