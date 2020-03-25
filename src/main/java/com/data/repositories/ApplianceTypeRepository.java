package com.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.ApplianceType;


@Repository
public interface ApplianceTypeRepository extends JpaRepository<ApplianceType, Integer> {

}
