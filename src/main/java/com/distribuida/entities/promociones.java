package com.distribuida.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="promociones")
public class promociones {

	
	// Atributos 
	//id_promocion, Nombre, Descuento, FechaInicio, FechaFin


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promocion")
	private int idPromocion;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Descuento")
	private double descuento;
	@Column(name = "FechaInicio")
	private Date fechaInicio;
	@Column(name = "FechaFin")
	private Date fechaFin;
	
	
	// Constructor 
	
	public promociones() { }

	
	public promociones(int idPromocion, String nombre, double descuento, Date fechainicio, Date fechafin) {
		
		this.idPromocion = idPromocion;
		this.nombre = nombre;
		this.descuento = descuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}




	

	public int getIdPromocion() {
		return idPromocion;
	}


	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechainicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechafin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Override
	public String toString() {
		return "promociones [idPromocion=" + idPromocion + ", nombre=" + nombre + ", descuento=" + descuento
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}

