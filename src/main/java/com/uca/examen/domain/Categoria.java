package com.uca.examen.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer codigoCategoria;
	
	@Column(name="s_categoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy="codigoCategoria",fetch=FetchType.EAGER)
	private List<Libro> libros;
	
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}



	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}



	public String getNombreCategoria() {
		return nombreCategoria;
	}



	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}



	public List<Libro> getLibros() {
		return libros;
	}



	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}



	public Categoria() {}
	
	
	

}
