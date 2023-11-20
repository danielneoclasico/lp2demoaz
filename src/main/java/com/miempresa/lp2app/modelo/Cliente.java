package com.miempresa.lp2app.modelo;


import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // INT
	@NotBlank(message = "Debe ingresar nombre")
	@Length(max = 50, message = "El nombre debe tener maximo 50 letras")
	private String nombre; // VARCHAR
	@NotEmpty(message = "Debe ingresar ciudad")
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "Solo letras")
	private String ciudad; // VARCHAR
	
	//@Max(value = 10000,message = "El credito no debe ser mayor a 10000")
	//@Min(value = 1000,message = "El credito no debe ser menor a 10000")
	//@Pattern(regexp = "[0-9]+", message = "Solo numeros")
	@DecimalMax(value = "10000",message = "El credito no debe ser mayor a 10000")
	private double credito; // DECIMAL
	@ManyToOne
	private TipoCliente tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public TipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	
}
