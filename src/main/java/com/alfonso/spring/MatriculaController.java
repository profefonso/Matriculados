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

import com.alfonso.spring.model.Curso;
import com.alfonso.spring.model.Estudiante;
import com.alfonso.spring.model.Matricula;
import com.alfonso.spring.service.MatriculaService;

@Controller
public class MatriculaController {
	
	private MatriculaService matriculaService;
	
	@Autowired(required=true)
	@Qualifier(value="matriculaService")
	public void setMatriculaService(MatriculaService ms){
		this.matriculaService = ms;
	}
	
	@RequestMapping(value = "/matriculas", method = RequestMethod.GET)
	public String listMatriculas(Model model) {
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("listMatriculas", this.matriculaService.listMatriculas());
		return "matricula";
	}
	
	@RequestMapping(value = "/matriculas/all", method = RequestMethod.GET)
	public String matricular(Model model) {
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("listMatriculas", this.matriculaService.listMatriculas());
		return "allmatriculas";
	}
	
	//For add and update person both
	@RequestMapping(value= "/matricula/new", method = RequestMethod.POST)
	public String newMatricula(@RequestParam("id_estudiante") String id_estudiante, Model model){
		int id_est=Integer.parseInt(id_estudiante);
		Estudiante estudiante=new Estudiante();
		estudiante=this.matriculaService.getEstudianteById(id_est);
		Matricula matricula=new Matricula();
		matricula.setEstudiante(estudiante);
		model.addAttribute("listCursos", this.matriculaService.listCursos());
		model.addAttribute("matricula", matricula);
        model.addAttribute("estudiante", estudiante);
		
		return "matricula";
		
	}
	
	@RequestMapping(value= "/matricula/add", method = RequestMethod.POST)
	public String addMatricula(@RequestParam("id_matricula") int id_matricula, 
			@RequestParam("estudiante_id") String estudiante_id, 
			@RequestParam("curso") String curso, @RequestParam("nota") String nota,
			@RequestParam("comentario") String comentario, Model model){
		int id_est=Integer.parseInt(estudiante_id);
		Curso c=this.matriculaService.getCursoByName(curso);
		Estudiante e=this.matriculaService.getEstudianteById(id_est);
		Matricula m=new Matricula();
		if(id_matricula != 0){
			m=this.matriculaService.getMatriculaById(id_matricula);
		}
		m.setCurso(c);
		m.setEstudiante(e);
		m.setNota(nota);
		m.setComentario(comentario);
		if(id_matricula == 0){
			this.matriculaService.addMatricula(m);
		}else{
			this.matriculaService.updateMatricula(m);
		}
		
		return "redirect:/estudiante/edit/"+estudiante_id;
	}
	
	@RequestMapping("matricula/remove/{id}")
    public String removeMatricula(@PathVariable("id") int id){
        this.matriculaService.removeMatricula(id);
        return "redirect:/matricula";
    }
 
    @RequestMapping("matricula/edit/{id}")
    public String editMatricula(@PathVariable("id") int id, Model model){
    	Matricula matricula =this.matriculaService.getMatriculaById(id);
        model.addAttribute("matricula", matricula);
        model.addAttribute("estudiante", matricula.getEstudiante());
        model.addAttribute("curso", matricula.getCurso());
        return "editarnota";
    }
	
}
