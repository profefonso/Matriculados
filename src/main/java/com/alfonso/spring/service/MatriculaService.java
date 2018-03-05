package com.alfonso.spring.service;

import java.util.List;

import com.alfonso.spring.model.Curso;
import com.alfonso.spring.model.Estudiante;
import com.alfonso.spring.model.Matricula;

public interface MatriculaService {

	public void addMatricula(Matricula m);
	public void updateMatricula(Matricula m);
	public List<Matricula> listMatriculas();
	public Matricula getMatriculaById(int id);
	public void removeMatricula(int id);
	public Estudiante getEstudianteById(int id);
	public List<Curso> listCursos();
	public Curso getCursoByName(String name);
}
