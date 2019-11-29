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

import com.nttdata.SpringBootDemo.Services.StudenteServices;
import com.nttdata.SpringBootDemo.model.StudenteEntity;

@Controller
@RequestMapping("/")
public class AppControllerRepo {

	@Autowired
	private StudenteServices studenteServices;

	@RequestMapping("/students")
	public String viewHomePage(Model model) {
		List<StudenteEntity> listaStudenti = studenteServices.findAll();
		model.addAttribute("listaStudenti", listaStudenti);
		return "list_students";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		StudenteEntity studente = new StudenteEntity();
		model.addAttribute("studente", studente);
		return "new_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("studente") StudenteEntity studente) {
		studenteServices.save(studente);
		return "redirect:/students";
	}

	@RequestMapping("/edit/{matricola}")
	public ModelAndView showEditForm(@PathVariable(name = "matricola") String matricola) {
		ModelAndView mav = new ModelAndView("edit_form");
		StudenteEntity studente = studenteServices.findById(matricola);
//				.orElseThrow(
//				() -> new IllegalArgumentException("Matricola non valida:" + matricola));
		mav.addObject("studente", studente);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("studente") StudenteEntity studente) {
		studenteServices.save(studente);
		return "redirect:/students";
	}

	@RequestMapping("/delete/{matricola}")
	public String delete(@PathVariable(name = "matricola") String matricola) {
		studenteServices.delete(matricola);
		return "redirect:/students";      
	}


}
