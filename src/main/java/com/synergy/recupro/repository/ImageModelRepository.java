package com.synergy.recupro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.recupro.model.ImageModel;

@Repository
public interface ImageModelRepository extends JpaRepository<ImageModel, Long> {
}
