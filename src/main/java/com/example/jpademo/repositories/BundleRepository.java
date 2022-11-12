package com.example.jpademo.repositories;

import com.example.jpademo.entities.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long>, JpaSpecificationExecutor<Bundle> {
}