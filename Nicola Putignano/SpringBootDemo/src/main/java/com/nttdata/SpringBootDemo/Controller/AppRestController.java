package com.nttdata.SpringBootDemo.Controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.SpringBootDemo.Repository.StudenteRepository;
import com.nttdata.SpringBootDemo.model.StudenteEntity;



@RestController
@RequestMapping("/repo-rest")
public class AppRestController {

	@Autowired
	private StudenteRepository studenteRepository;

	@GetMapping("/")
	public List<StudenteEntity> findAll() {
		return (List<StudenteEntity>) studenteRepository.findAll();
	}
	
	@GetMapping("/{matricola}")
	public StudenteEntity getById(@PathVariable("matricola") String matricola) {
		return studenteRepository.findById(matricola)
			      .orElseThrow(() -> new EntityNotFoundException(matricola));
	}

	@PostMapping
	public StudenteEntity create(@RequestBody StudenteEntity studente) {
		return studenteRepository.save(studente);
	}

	@PutMapping("/{matricola}")
	public StudenteEntity update(@PathVariable("matricola") String matricola, @RequestBody StudenteEntity studente) {
		return studenteRepository.save(studente);
				
	}

	@DeleteMapping("/{matricola}")
	public void delete(@PathVariable("matricola") String matricola) {
		studenteRepository.deleteById(matricola);
	}

}
