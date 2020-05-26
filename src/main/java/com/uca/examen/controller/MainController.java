package com.uca.examen.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.examen.dao.CategoriaDAO;
import com.uca.examen.dao.LibroDAO;
import com.uca.examen.domain.Categoria;
import com.uca.examen.domain.Libro;

@Transactional
@Controller
public class MainController {

	@Autowired
	private CategoriaDAO categoriaDao;
	@Autowired
	private LibroDAO libroDao;
	
	@GetMapping("/index")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");	
		return mav;		
	}
	//TODO 1: Parte de insercion de una categoria
	@GetMapping("/categoria")
	public ModelAndView insertCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria cat = new Categoria();
		
		mav.addObject("categoria", cat);
		mav.setViewName("categoria");
		return mav;
	}
	
	@PostMapping("/agregarCategoria")
	public ModelAndView agregarCategoria(@ModelAttribute Categoria cat, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		try {
			//if(result.hasErrors()) {
				//	mav.setViewName("categoria");
			//}else {
				//categoriaDao.insertCategoria(cat);
				categoriaDao.insertCategoria(cat);//BORRAR ESTA LINEA UNA VEZ SE PUEDA VALIDAR
				mav.setViewName("index");
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return mav;
	}
	//Fin de insercion de una categoria
	
	//TODO 2:Inicio de parte de insercion de un libro
	
	@GetMapping("/libro")
	public ModelAndView insertLibro() {
		ModelAndView mav = new ModelAndView();
		Categoria cat = new Categoria();
		
		mav.addObject("categoria", cat);
		mav.setViewName("categoria");
		return mav;
	}
	
	@PostMapping("/agregarLibro")
	public ModelAndView agregarLibro(@ModelAttribute Libro libro, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		try {
			//if(result.hasErrors()) {
				//	mav.setViewName("categoria");
			//}else {
				//categoriaDao.insertCategoria(cat);
				libroDao.insertLibro(libro);//BORRAR ESTA LINEA UNA VEZ SE PUEDA VALIDAR
				mav.setViewName("index");
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
