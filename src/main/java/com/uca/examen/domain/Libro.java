package com.uca.examen.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer codigoLibro;
	
	@Column(name="s_titulo")
	private String nombreTitulo;
	
	@Column(name="s_autor")
	private String nombreAutor;
	
	@JoinColumn(name="c_categoria")
	@ManyToOne(fetch=FetchType.EAGER)
	Categoria codigoCategoria;
	
	@Column(name="f_ingreso")
	private Date fechaIngreso;
	
	@Column(name="b_estado")
	private Boolean estadoLibro;
	
	@Column(name="s_isbn")
	private String nombreIsbn;
	
	public Libro() {}
	
	
	
	public Integer getCodigoLibro() {
		return codigoLibro;
	}



	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}



	public String getNombreTitulo() {
		return nombreTitulo;
	}



	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}



	public String getNombreAutor() {
		return nombreAutor;
	}



	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}



	public Categoria getCodigoCategoria() {
		return codigoCategoria;
	}



	public void setCodigoCategoria(Categoria codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public Boolean getEstadoLibro() {
		return estadoLibro;
	}



	public void setEstadoLibro(Boolean estadoLibro) {
		this.estadoLibro = estadoLibro;
	}



	public String getNombreIsbn() {
		return nombreIsbn;
	}



	public void setNombreIsbn(String nombreIsbn) {
		this.nombreIsbn = nombreIsbn;
	}



	//Delegate
	public String getNombreCategoria() {
		if(this.codigoCategoria==null)return "-";
		else {
			for(int i=0;i<codigoCategoria.getLibros().size();i++) {
				return codigoCategoria.getLibros().get(i).getNombreCategoria();
			}
		}
		return "";
	}	
	
}
