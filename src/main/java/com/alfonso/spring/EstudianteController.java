package com.alfonso.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alfonso.spring.model.Estudiante;
import com.alfonso.spring.service.EstudianteService;

@Controller
public class EstudianteController {
	
	private EstudianteService estudianteService;
	
	@Autowired(required=true)
	@Qualifier(value="estudianteService")
	public void setEstudianteService(EstudianteService es){
		this.estudianteService = es;
	}
	
	@RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
	public String listEstudiantes(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		model.addAttribute("listEstudiantes", this.estudianteService.listEstudiantes());
		return "estudiante";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEstudiantesTwo(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		model.addAttribute("listEstudiantes", this.estudianteService.listEstudiantes());
		return "inicio";
	}
	
	@RequestMapping(value = "/estudiantes/all", method = RequestMethod.GET)
	public String allEstudiantes(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		model.addAttribute("listEstudiantes", this.estudianteService.listEstudiantes());
		return "allestudiantes";
	}
		
	//For add and update person both
	@RequestMapping(value= "/estudiante/add", method = RequestMethod.POST)
	public String addEstudiante(@ModelAttribute("estudiante") Estudiante e){
		
		if(e.getId() == 0){
			this.estudianteService.addEstudiante(e);
		}else{
			this.estudianteService.updateEstudiante(e);
		}
		
		return "redirect:/estudiantes/all";
		
	}
	
	//For add and update person both
	@RequestMapping(value= "/estudiante/sel", method = RequestMethod.POST)
	public String selEstudiante(@RequestParam("nombre") String nombre){
		Estudiante e= this.estudianteService.getEstudianteByName(nombre);
			return "redirect:/estudiante/edit/"+e.getId();
	}
	
	@RequestMapping("estudiante/remove/{id}")
    public String removeEstudiante(@PathVariable("id") int id){
        this.estudianteService.removeEstudiante(id);
        return "redirect:/estudiantes/all";
    }
 
    @RequestMapping("estudiante/edit/{id}")
    public String editEstudiante(@PathVariable("id") int id, Model model){
        model.addAttribute("estudiante", this.estudianteService.getEstudianteById(id));
        model.addAttribute("listEstudiantes", this.estudianteService.listEstudiantes());
        return "estudiante";
    }
	
}
