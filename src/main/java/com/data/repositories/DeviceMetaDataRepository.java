package com.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.ApplianceType;
import com.data.model.ApplienceMetaData;
import com.data.model.DeviceMetaData;


@Repository
public interface DeviceMetaDataRepository extends JpaRepository<DeviceMetaData, Integer> {

}
