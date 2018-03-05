package com.alfonso.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alfonso.spring.model.Curso;
import com.alfonso.spring.model.Estudiante;
import com.alfonso.spring.model.Matricula;

@Repository
public class MatriculaDAOImpl implements MatriculaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MatriculaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMatricula(Matricula m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
		logger.info("Person saved successfully, Person Details="+m);
	}

	@Override
	public void updateMatricula(Matricula m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
		logger.info("Person updated successfully, Matricula Details="+m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listMatriculas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Matricula> matriculaList = session.createQuery("from Matricula").list();
		for(Matricula m : matriculaList){
			logger.info("Matricula List::"+m);
		}
		return matriculaList;
	}

	@Override
	public Matricula getMatriculaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Matricula m = (Matricula) session.load(Matricula.class, new Integer(id));
		logger.info("Matricula loaded successfully, Person details="+m);
		return m;
	}

	@Override
	public void removeMatricula(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Matricula m = (Matricula) session.load(Matricula.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Matricula deleted successfully, person details="+m);
	}

	@Override
	public Estudiante getEstudianteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Estudiante e = (Estudiante) session.load(Estudiante.class, new Integer(id));
		logger.info("Estudiante loaded successfully, Person details="+e);
		return e;
	}

	@Override
	public List<Curso> listCursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Curso> cursoList = session.createQuery("from Curso").list();
		for(Curso c : cursoList){
			logger.info("Curso List::"+c);
		}
		return cursoList;
	}

	@Override
	public Curso getCursoByName(String name) {
		Curso curso = new Curso();
		Session session = this.sessionFactory.getCurrentSession();
		String hsql="FROM Curso c WHERE c.nombre ='"+name+"'";
		List<Curso> cursoList = session.createQuery(hsql).list();
		for(Curso c : cursoList){
			curso=c;
		}
		return curso;
	}
}
