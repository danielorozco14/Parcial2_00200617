package com.uca.examen.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.examen.domain.Categoria;

@Repository
public class CategoriaImpl implements CategoriaDAO {

	@PersistenceContext(unitName="parcial2")
	public EntityManager entityManager;
	
	@Override
	public List<Categoria>findAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM PUBLIC.cat_categoria;");
		Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> result = query.getResultList();
		
		return result;
	}
	
	@Override
	public void insertCategoria(Categoria categoria) throws DataAccessException{
		entityManager.persist(categoria);
	}
	
}
