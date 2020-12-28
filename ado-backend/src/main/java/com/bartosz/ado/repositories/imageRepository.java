package com.bartosz.ado.repositories;

import com.bartosz.ado.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface imageRepository extends JpaRepository<Image, Integer> {
}
