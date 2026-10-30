package com.temple.repository;

import com.temple.model.entity.LightItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightItemRepository extends JpaRepository<LightItem, Integer> {

    List<LightItem> findByLightOidOrderByDateDescOidDesc(Integer lightOid);
}
