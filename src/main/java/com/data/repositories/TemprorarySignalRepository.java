package com.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.data.model.TempSignal;

public interface TemprorarySignalRepository  extends JpaRepository<TempSignal, Integer> {

}
