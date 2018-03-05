package com.alfonso.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alfonso.spring.dao.EstudianteDAO;
import com.alfonso.spring.model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	private EstudianteDAO estudianteDAO;

	public void setEstudianteDAO(EstudianteDAO EstudianteDAO) {
		this.estudianteDAO = EstudianteDAO;
	}

	@Override
	@Transactional
	public void addEstudiante(Estudiante e) {
		this.estudianteDAO.addEstudiante(e);
	}

	@Override
	@Transactional
	public void updateEstudiante(Estudiante e) {
		this.estudianteDAO.updateEstudiante(e);
	}

	@Override
	@Transactional
	public List<Estudiante> listEstudiantes() {
		return this.estudianteDAO.listEstudiantes();
	}

	@Override
	@Transactional
	public Estudiante getEstudianteById(int id) {
		return this.estudianteDAO.getEstudianteById(id);
	}

	@Override
	@Transactional
	public void removeEstudiante(int id) {
		this.estudianteDAO.removeEstudiante(id);
	}

	@Override
	@Transactional
	public Estudiante getEstudianteByName(String nombre) {
		return this.estudianteDAO.getEstudianteByName(nombre);
	}

}
