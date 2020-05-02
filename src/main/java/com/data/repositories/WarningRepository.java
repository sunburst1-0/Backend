package com.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.data.model.Warning;


@Repository
public interface WarningRepository extends JpaRepository<Warning, Integer> {

}
