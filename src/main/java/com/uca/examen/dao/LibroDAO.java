package com.uca.examen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.examen.domain.Libro;

public interface LibroDAO {
	
	public List<Libro>findAll() throws DataAccessException;
	
	@Transactional
	public void insertLibro(Libro libro) throws DataAccessException;
	
	
}
