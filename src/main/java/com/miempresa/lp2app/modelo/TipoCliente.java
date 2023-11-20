package com.miempresa.lp2app.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="tipo_cliente")
public class TipoCliente {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="tipo")
	private String tipo;
	@OneToMany(mappedBy="tipo")
	private List<Cliente> clientes;
	
	public TipoCliente(){
	}
	public TipoCliente(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
