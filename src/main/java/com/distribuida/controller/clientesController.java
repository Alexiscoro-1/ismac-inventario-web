package com.distribuida.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.clientesDAO;
import com.distribuida.entities.clientes;

@Controller
@RequestMapping("/clientes")    	// path principal 
 
public class clientesController {

	
	// JSP .- Java Server Page, son las paginas web de tecnologia 
	@Autowired
	private clientesDAO clientesDAO;
	
	
	@GetMapping("/findAll")  		//path secundario
	public String findAll (Model model ) {
		

		List<clientes> clientes = clientesDAO.findALL();
		
		model.addAttribute("clientes", clientes);
		
		return "listar-clientes" ;  //Esto es el nombre del formulario 
		
//		}catch (Exception e) {
//		//TODO: handle exception
//		e.printStackTrace();
//	  }
	
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idcliente") @Nullable Integer idcliente
						 ,@RequestParam("opcion") @Nullable Integer opcion
						 ,Model model
			) {
		//try {

		if(idcliente != null) {
			clientes clientes = clientesDAO.findOne(idcliente);
			model.addAttribute("clientes", clientes);	
		}
		
		if(opcion ==1) return "add-clientes";
		else return "del-clientes";

//		}catch (Exception e) {
//		//TODO: handle exception
//		e.printStackTrace();
//	  }
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idcliente")@Nullable Integer idcliente
					,@RequestParam("Nombre")@Nullable String Nombre
					,@RequestParam("Direccion")@Nullable String Direccion
					,@RequestParam("Telefono")@Nullable String Telefono
					,@RequestParam("Email")@Nullable String Email
					, Model model 
			) {
		
		//try {

		if(idcliente == null) {
		clientes clientes = new clientes(0, Nombre, Direccion, Telefono, Email);
		clientesDAO.add(clientes);
		
		}else {
			
		clientes clientes2 = new clientes(idcliente, Nombre, Direccion, Telefono, Email);
		clientesDAO.up(clientes2);	
		}
		return "redirect:/clientes/findAll";
		
//		}catch (Exception e) {
//		//TODO: handle exception
//	  }
	
	}
	

	//try {

	@GetMapping ("/del")
	public String del(@RequestParam("idcliente")@Nullable Integer idcliente) {
		
		clientesDAO.del(idcliente);
		return "redirect:/clientes/finAll";
		
//		}catch (Exception e) {
//		//TODO: handle exception
//	  }
	
	}
	
}






