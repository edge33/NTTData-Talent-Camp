package com.nttdata.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.SpringBootDemo.Services.CorsoServices;
import com.nttdata.SpringBootDemo.model.CorsoDiLaureaEntity;


@Controller
@RequestMapping("/")
public class CourseControllerRepo {
	
	@Autowired
	private CorsoServices corsoServices;
	
	@RequestMapping("/courses")
	public String viewHomePage(Model model) {
		List<CorsoDiLaureaEntity> listaCorsi = corsoServices.findAll();
		model.addAttribute("listaCorsi", listaCorsi);
		return "list_courses";
	}
	
	@RequestMapping("/courses/new")
	public String showNewForm(Model model) {
		CorsoDiLaureaEntity corsoDiLaurea = new CorsoDiLaureaEntity();
		model.addAttribute("corsoDiLaurea", corsoDiLaurea);
		return "new_course_form";
	}
	@RequestMapping(value = "/courses/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("corsoDiLaurea") CorsoDiLaureaEntity corsoDiLaurea) {
		corsoServices.save(corsoDiLaurea);
		return "redirect:/courses";
	}

	@RequestMapping("/courses/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_course_form");
		CorsoDiLaureaEntity corsoDiLaurea = corsoServices.findById(id);
//				.orElseThrow(
//				() -> new IllegalArgumentException("Matricola non valida:" + matricola));
		mav.addObject("corsoDiLaurea", corsoDiLaurea);

		return mav;
	}

	@RequestMapping(value = "/courses/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("corso") CorsoDiLaureaEntity corsoDiLaurea) {
		corsoServices.save(corsoDiLaurea);
		return "redirect:/courses";
	}

	@RequestMapping("/courses/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		corsoServices.delete(id);
		return "redirect:/courses";      
	}

}
