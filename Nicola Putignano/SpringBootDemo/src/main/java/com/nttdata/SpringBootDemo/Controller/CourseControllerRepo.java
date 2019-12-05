package com.nttdata.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.SpringBootDemo.Services.CorsoServices;
import com.nttdata.SpringBootDemo.dto.CorsoDiLaureaDto;
import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;


@Controller
@RequestMapping("/")
public class CourseControllerRepo {
	
	private static final String REDIRECT="redirect:/courses";
	
	@Autowired
	private CorsoServices corsoServices;
	
	@GetMapping("/courses")
	public String viewHomePage(Model model) {
		List<CorsoDiLaureaDto> listaCorsi = corsoServices.findAll();
		model.addAttribute("listaCorsi", listaCorsi);
		return "list_courses";
	}
	
	@GetMapping("/courses/new")
	public String showNewForm(Model model) {
		CorsoDiLaureaEntity corsoDiLaurea = new CorsoDiLaureaEntity();
		model.addAttribute("corsoDiLaurea", corsoDiLaurea);
		return "new_course_form";
	}
	@PostMapping(value = "/courses/save")
	public String save(@ModelAttribute("corsoDiLaurea") CorsoDiLaureaDto corsoDiLaurea) {
		corsoServices.save(corsoDiLaurea);
		return REDIRECT;
	}

	@GetMapping("/courses/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_course_form");
		CorsoDiLaureaDto corsoDiLaurea = corsoServices.findById(id);
		mav.addObject("corsoDiLaurea", corsoDiLaurea);

		return mav;
	}

	@PostMapping(value = "/courses/update")
	public String update(@ModelAttribute("corso") CorsoDiLaureaDto corsoDiLaurea) {
		return save(corsoDiLaurea);
	}

	@GetMapping("/courses/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		corsoServices.delete(id);
		return REDIRECT;      
	}

}
