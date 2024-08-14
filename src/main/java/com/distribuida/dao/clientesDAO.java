package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.clientes;

public interface clientesDAO {


		public List<clientes> findALL();
		
		public clientes findOne(int id);
		
		public void add(clientes Clientes);
		
		public void up(clientes Clientes);
		
		public void del(int id);
		
	}


