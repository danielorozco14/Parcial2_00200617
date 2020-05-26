package com.uca.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.examen.domain.Libro;

@Repository
public class LibroImpl implements LibroDAO{
	
	@PersistenceContext(unitName="parcial2")
	public EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM PUBLIC.cat_libro;");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List <Libro> result = query.getResultList();
		return result;
	}
	@Override
	public void insertLibro(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
		
	}
	
	
	
}
