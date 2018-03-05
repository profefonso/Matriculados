package com.alfonso.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Alfonso
 *
 */
@Entity
@Table(name="estudiantes")
public class Estudiante {

	private int id;
	private String nombre;
	private Integer edad;
	private String correo;
	
	private Set<Matricula> matriculas;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void setmatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

	@Override
	public String toString(){
		return nombre;
	}
}
