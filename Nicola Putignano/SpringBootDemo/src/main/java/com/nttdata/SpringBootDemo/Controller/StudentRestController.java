package com.nttdata.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.SpringBootDemo.Services.StudenteServices;
import com.nttdata.SpringBootDemo.dto.StudenteDto;

@RestController
@RequestMapping("/students-rest")
public class StudentRestController {

	@Autowired
	private StudenteServices studenteService;

	@GetMapping("/")
	public List<StudenteDto> findAll() {
		return studenteService.findAll();
	}
	
	@GetMapping("/{matricola}")
	public StudenteDto getById(@PathVariable("matricola") String matricola) {
		return studenteService.findById(matricola);
			      
	}

	@PostMapping
	public void create(@RequestBody StudenteDto studente) {
		studenteService.save(studente);
	}

	@PutMapping("/{matricola}")
	public void update(@PathVariable("matricola") String matricola, @RequestBody StudenteDto studente) {
		studenteService.save(studente);
				
	}

	@DeleteMapping("/{matricola}")
	public void delete(@PathVariable("matricola") String matricola) {
		studenteService.delete(matricola);
	}

}
