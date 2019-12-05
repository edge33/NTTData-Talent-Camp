package com.nttdata.SpringBootDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.SpringBootDemo.Services.StudenteServices;
import com.nttdata.SpringBootDemo.dto.StudenteDto;


@Controller
@RequestMapping("/")
public class StudentControllerRepo {
	
	private static final String REDIRECT = "redirect:/students";
	@Autowired
	private StudenteServices studenteServices;

	@GetMapping(value = "/students")
	public String viewHomePage(Model model) {
		List<StudenteDto> listaStudenti = studenteServices.findAll();
		model.addAttribute("listaStudenti", listaStudenti);
		return "list_students";
	}

	@GetMapping(path = "/new")
	public String showNewForm(Model model) {
		StudenteDto studente = new StudenteDto();
		model.addAttribute("studente", studente);
		return "new_form";
	}

	@PostMapping(value = "/save")
	public String save(@ModelAttribute("studente") StudenteDto studente) {
		studenteServices.save(studente);
		return REDIRECT;
	}
	
	@GetMapping(value = "/edit/{matricola}")
	public ModelAndView showEditForm(@PathVariable(name = "matricola") String matricola) {
		ModelAndView mav = new ModelAndView("edit_form");
		StudenteDto studente = studenteServices.findById(matricola);
		mav.addObject("studente", studente);

		return mav;
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("studente") StudenteDto studente) {
		return save(studente);
	}

	@DeleteMapping(value = "/delete/{matricola}")
	public String delete(@PathVariable(name = "matricola") String matricola) {
		studenteServices.delete(matricola);
		return REDIRECT;      
	}


}
