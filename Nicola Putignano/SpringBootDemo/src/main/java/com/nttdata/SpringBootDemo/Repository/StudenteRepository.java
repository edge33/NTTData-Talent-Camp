package com.nttdata.SpringBootDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.SpringBootDemo.model.StudenteEntity;


@Repository
public interface StudenteRepository extends CrudRepository <StudenteEntity, String>{

	StudenteEntity findByMatricola(String matricola);
	
}
