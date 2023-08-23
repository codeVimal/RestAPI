package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DonorEntity;

public interface Repo extends JpaRepository<DonorEntity, Integer>{

}
