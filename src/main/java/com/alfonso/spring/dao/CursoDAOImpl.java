package com.alfonso.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alfonso.spring.model.Curso;

@Repository
public class CursoDAOImpl implements CursoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CursoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCurso(Curso c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Curso saved successfully, Curso Details="+c);
	}

	@Override
	public void updateCurso(Curso c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Curso updated successfully, Curso Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listCursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Curso> CursosList = session.createQuery("from Curso").list();
		for(Curso c : CursosList){
			logger.info("Curso List::"+c);
		}
		return CursosList;
	}

	@Override
	public Curso getCursoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Curso c = (Curso) session.load(Curso.class, new Integer(id));
		logger.info("Curso loaded successfully, Curso details="+c);
		return c;
	}

	@Override
	public void removeCurso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Curso c = (Curso) session.load(Curso.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Curso deleted successfully, Curso details="+c);
	}

}
