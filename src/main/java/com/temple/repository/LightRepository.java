package com.temple.repository;

import com.temple.model.entity.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightRepository extends JpaRepository<Light, Integer> {

    List<Light> findAllByOrderByYearDescOidDesc();

    boolean existsByYear(String year);
}
