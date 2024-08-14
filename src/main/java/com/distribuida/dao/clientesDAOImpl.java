package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.clientes;
 
@Repository
public class clientesDAOImpl implements clientesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<clientes>  findALL(){
		//TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("from clientes",clientes.class).getResultList();
	}
	
	
	
	@Override
	@Transactional
	public clientes findOne(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.get(clientes.class, id);
	}

	@Override
	@Transactional

	public void add(clientes clientes) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(clientes);
	}

	@Override
	@Transactional

	public void up(clientes clientes) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(clientes);
	}

	@Override
	@Transactional

	public void del(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(findOne(id));

	}

}
