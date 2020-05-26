package com.uca.examen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.examen.domain.Categoria;
import com.uca.examen.domain.Libro;

public interface CategoriaDAO {
	public List<Categoria>findAll() throws DataAccessException;
	
	@Transactional
	public void insertCategoria(Categoria categoria) throws DataAccessException;
}
