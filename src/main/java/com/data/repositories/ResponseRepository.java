package com.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
	import com.data.model.Response;



@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {

}
