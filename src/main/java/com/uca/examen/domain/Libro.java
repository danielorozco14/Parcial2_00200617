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
	
	@Column(name="autor")
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
