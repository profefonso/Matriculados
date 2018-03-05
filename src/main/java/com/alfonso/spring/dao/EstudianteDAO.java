package com.alfonso.spring.dao;

import java.util.List;

import com.alfonso.spring.model.Estudiante;

public interface EstudianteDAO {

	public void addEstudiante(Estudiante e);
	public void updateEstudiante(Estudiante e);
	public List<Estudiante> listEstudiantes();
	public Estudiante getEstudianteById(int id);
	public void removeEstudiante(int id);
	public Estudiante getEstudianteByName(String nombre);
}
