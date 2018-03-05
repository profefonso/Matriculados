package com.alfonso.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alfonso.spring.model.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EstudianteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEstudiante(Estudiante e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Person saved successfully, Person Details="+e);
	}

	@Override
	public void updateEstudiante(Estudiante e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Person updated successfully, Person Details="+e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> listEstudiantes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Estudiante> estudianteList = session.createQuery("from Estudiante").list();
		for(Estudiante e : estudianteList){
			logger.info("Estudiante List::"+e);
		}
		return estudianteList;
	}

	@Override
	public Estudiante getEstudianteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Estudiante e = (Estudiante) session.load(Estudiante.class, new Integer(id));
		logger.info("Estudiante loaded successfully, Person details="+e);
		return e;
	}

	@Override
	public void removeEstudiante(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Estudiante e = (Estudiante) session.load(Estudiante.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
		logger.info("Estudiante deleted successfully, person details="+e);
	}

	@Override
	public Estudiante getEstudianteByName(String nombre) {
		Estudiante estudiante=new Estudiante();
		Session session = this.sessionFactory.getCurrentSession();
		String hsql="FROM Estudiante e WHERE e.nombre ='"+nombre+"'";
		List<Estudiante> estList = session.createQuery(hsql).list();
		for(Estudiante es : estList){
			estudiante=es;
		}
		return estudiante;
	}


}
