package com.alfonso.spring.service;

import java.util.List;

import com.alfonso.spring.model.Curso;


public interface CursoService {

	public void addCurso(Curso p);
	public void updateCurso(Curso p);
	public List<Curso> listCursos();
	public Curso getCursoById(int id);
	public void removeCurso(int id);
	
}
