package com.alfonso.spring.dao;

import java.util.List;

import com.alfonso.spring.model.Curso;


public interface CursoDAO {

	public void addCurso(Curso c);
	public void updateCurso(Curso c);
	public List<Curso> listCursos();
	public Curso getCursoById(int id);
	public void removeCurso(int id);
}
