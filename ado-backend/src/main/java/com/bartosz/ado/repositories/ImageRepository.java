package com.bartosz.ado.repositories;

import com.bartosz.ado.models.Image;
import com.bartosz.ado.models.dtos.ImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("Select i from Image i where i.id_user = :id")
    Page<Image> selectAllImages(@Param("id") int id, Pageable paging);

    @Query("Select i from Image i where i.id_user = :id and i.image_name like %:name%")
    Page<Image> selectFilteredImages(@Param("id")int id, Pageable paging, @Param("name")String name);
}
