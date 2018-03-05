package com.alfonso.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.spring.dao.MatriculaDAO;
import com.alfonso.spring.model.Curso;
import com.alfonso.spring.model.Estudiante;
import com.alfonso.spring.model.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	private MatriculaDAO matriculaDAO;

	public void setMatriculaDAO(MatriculaDAO MatriculaDAO) {
		this.matriculaDAO = MatriculaDAO;
	}

	@Override
	@Transactional
	public void addMatricula(Matricula m) {
		this.matriculaDAO.addMatricula(m);
	}

	@Override
	@Transactional
	public void updateMatricula(Matricula m) {
		this.matriculaDAO.updateMatricula(m);
	}

	@Override
	@Transactional
	public List<Matricula> listMatriculas() {
		return this.matriculaDAO.listMatriculas();
	}

	@Override
	@Transactional
	public Matricula getMatriculaById(int id) {
		return this.matriculaDAO.getMatriculaById(id);
	}

	@Override
	@Transactional
	public void removeMatricula(int id) {
		this.matriculaDAO.removeMatricula(id);
	}
	
	@Override
	@Transactional
	public Estudiante getEstudianteById(int id) {
		return this.matriculaDAO.getEstudianteById(id);
	}

	@Override
	@Transactional
	public List<Curso> listCursos() {
		return this.matriculaDAO.listCursos();
	}

	@Override
	@Transactional
	public Curso getCursoByName(String name) {
		return this.matriculaDAO.getCursoByName(name);
	}

}
