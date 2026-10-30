package com.temple.repository;

import com.temple.model.entity.LightItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightItemDetailRepository extends JpaRepository<LightItemDetail, Integer> {

    List<LightItemDetail> findByLightItemOidOrderByOidAsc(Integer lightItemOid);

    List<LightItemDetail> findByLightItemOidInOrderByOidAsc(List<Integer> lightItemOids);
}
