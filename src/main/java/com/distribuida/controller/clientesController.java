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

	
	@Autowired
	private clientesDAO clientesDAO;
	
	
	@GetMapping("/findAll")  		//path secundario
	public String findAll (Model model ) {
		

		List<clientes> clientes = clientesDAO.findALL();
		
		model.addAttribute("clientes", clientes);
		
		return "listar-clientes" ;  //Esto es el nombre del formulario 
		
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idcliente") @Nullable Integer idcliente
						 ,@RequestParam("opcion") @Nullable Integer opcion
						 ,Model model
			) {

		if(idcliente != null) {
			clientes cliente = clientesDAO.findOne(idcliente);
			model.addAttribute("cliente", cliente);	
		}
		
		if(opcion !=  null && opcion ==1) {
			
			 return "add-clientes"; // Vista para agregar o editar
        } else {
            return "del-clientes"; // Vista para confirmar eliminación
        }
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("idcliente")@Nullable Integer idcliente
					,@RequestParam("Nombre")@Nullable String Nombre
					,@RequestParam("Direccion")@Nullable String Direccion
					,@RequestParam("Telefono")@Nullable String Telefono
					,@RequestParam("Email")@Nullable String Email
					, Model model 
			) {
		
		if(idcliente == null) {
		clientes cliente = new clientes(0, Nombre, Direccion, Telefono, Email);
		clientesDAO.add(cliente);
		
		}else {
			
		clientes cliente = new clientes(idcliente, Nombre, Direccion, Telefono, Email);
		clientesDAO.up(cliente);	
		}
		return "redirect:/clientes/findAll";
		

	}
	



	@GetMapping("/del")
	public String del(@RequestParam("idcliente") @Nullable Integer idcliente) {
	    clientesDAO.del(idcliente);
	    return "redirect:/clientes/findAll";
	}

		

	}






