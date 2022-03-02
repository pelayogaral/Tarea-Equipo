package com.formacionspringboot.apirest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codArticulo;
	
	private String nombre;
	private String descripcion;
	private double precioUnidad;
	private int unidadesStock;
	private int stockSeguridad;
	private String imagen;
	public Long getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(Long codArticulo) {
		this.codArticulo = codArticulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getUnidadesStock() {
		return unidadesStock;
	}
	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}
	public int getStockSeguridad() {
		return stockSeguridad;
	}
	public void setStockSeguridad(int stockSeguridad) {
		this.stockSeguridad = stockSeguridad;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}	
	
}
