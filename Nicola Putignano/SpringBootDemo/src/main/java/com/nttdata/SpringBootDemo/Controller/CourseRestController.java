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

import com.nttdata.SpringBootDemo.Services.CorsoServices;
import com.nttdata.SpringBootDemo.dto.CorsoDiLaureaDto;

@RestController
@RequestMapping("/course-rest")
public class CourseRestController {

	@Autowired
	private CorsoServices corsoServices;
	
	@GetMapping("/")
	public List<CorsoDiLaureaDto> findAll (){
		List<CorsoDiLaureaDto> listaDto;
		listaDto = corsoServices.findAll();
		return listaDto;
	}
	
	@GetMapping("/{id}")
	public CorsoDiLaureaDto getById(@PathVariable("id") Long id) {
		return corsoServices.findById(id);
	}
	
	@PostMapping
	public void create(@RequestBody CorsoDiLaureaDto corso) {
		corsoServices.save(corso);
	}
	
	@PutMapping("/update-course/{id}")
	public void update(@PathVariable("matricola") Long id, @RequestBody CorsoDiLaureaDto corso) {
		corsoServices.save(corso);
				
	}

	@DeleteMapping("/delete-course/{id}")
	public void delete(@PathVariable("id") Long id) {
		corsoServices.delete(id);
	}

	
}
