package com.alfonso.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.spring.dao.CursoDAO;
import com.alfonso.spring.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	private CursoDAO CursoDAO;

	public void setCursoDAO(CursoDAO CursoDAO) {
		this.CursoDAO = CursoDAO;
	}

	@Override
	@Transactional
	public void addCurso(Curso c) {
		this.CursoDAO.addCurso(c);
	}

	@Override
	@Transactional
	public void updateCurso(Curso c) {
		this.CursoDAO.updateCurso(c);
	}

	@Override
	@Transactional
	public List<Curso> listCursos() {
		return this.CursoDAO.listCursos();
	}

	@Override
	@Transactional
	public Curso getCursoById(int id) {
		return this.CursoDAO.getCursoById(id);
	}

	@Override
	@Transactional
	public void removeCurso(int id) {
		this.CursoDAO.removeCurso(id);
	}

}
