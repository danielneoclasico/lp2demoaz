package com.miempresa.lp2app.repositorio;

//import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.lp2app.modelo.Cliente;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
/*
	List<Cliente> findByNombre(String nombre);
	List<Cliente> findByCiudad(String ciudad);
	List<Cliente> findByCreditoBetween(double min, double max);
	List<Cliente> findByNombreNull();
	List<Cliente> findByNombreLike(String nombre);
	List<Cliente> findByNombreContaining(String nombre);
	List<Cliente> findByCiudadOrderByNombre(String ciudad);
	@Query("select c from Cliente c order by c.nombre")
	List<Cliente> findAllOrdenadoPorNombre();
	@Query("select c from Cliente c")
	List<Cliente> findAllOrdenado(Sort sort);*/
}
