package com.alfonso.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alfonso.spring.model.Curso;
import com.alfonso.spring.service.CursoService;

@Controller
public class CursoController {
	
	private CursoService cursoService;
	
	@Autowired(required=true)
	@Qualifier(value="cursoService")
	public void setCursoService(CursoService ps){
		this.cursoService = ps;
	}
	
	@RequestMapping(value = "/cursos/all", method = RequestMethod.GET)
	public String listCursos(Model model) {
		model.addAttribute("curso", new Curso());
		model.addAttribute("listCursos", this.cursoService.listCursos());
		return "curso";
	}
	
	//For add and update Curso both
	@RequestMapping(value= "/curso/add", method = RequestMethod.POST)
	public String addCurso(@ModelAttribute("Curso") Curso c){
		
		if(c.getId() == 0){
			//new Curso, add it
			this.cursoService.addCurso(c);
		}else{
			//existing Curso, call update
			this.cursoService.updateCurso(c);
		}
		
		return "redirect:/cursos/all";
		
	}
	
	@RequestMapping("curso/remove/{id}")
    public String removeCurso(@PathVariable("id") int id){
		
        this.cursoService.removeCurso(id);
        return "redirect:/cursos/all";
    }
 
    @RequestMapping("curso/edit/{id}")
    public String editCurso(@PathVariable("id") int id, Model model){
        model.addAttribute("curso", this.cursoService.getCursoById(id));
        model.addAttribute("listCursos", this.cursoService.listCursos());
        return "curso";
    }
	
}
