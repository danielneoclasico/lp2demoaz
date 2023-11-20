package com.miempresa.lp2app.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.lp2app.modelo.Cliente;
import com.miempresa.lp2app.modelo.TipoCliente;
import com.miempresa.lp2app.repositorio.ClienteRepositorio;
import com.miempresa.lp2app.repositorio.TipoClienteRepositorio;



@Controller
public class ClienteControlador {
	
	@Autowired
	ClienteRepositorio cr;
	@Autowired
	TipoClienteRepositorio tcr;

	@GetMapping("/clientes")
	public String listar(@RequestParam(name="pagina",defaultValue = "1") int pagina, Model modelo) {
	
		PageRequest pr = PageRequest.of(pagina-1, 3);
		Page<Cliente> pc = cr.findAll(pr); 
		//List<Cliente> clientes = (List<Cliente>) cr.findAll();
		List<Cliente> clientes = pc.getContent();
		int totalPaginas = pc.getTotalPages();
		List<Integer> paginas = new ArrayList<Integer>();
		for (int i=1;i<=totalPaginas;i++)
			paginas.add(i);
		modelo.addAttribute("listaClientes", clientes);
		modelo.addAttribute("paginas", paginas);
		return "clientes";
	}
	
	@GetMapping("/clientes/nuevo")
	public String nuevo(Model modelo) {
		
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		List<TipoCliente> listaTipos = (List<TipoCliente>) tcr.findAll();
		modelo.addAttribute("tipos", listaTipos);
		return "nuevoCliente";
	}
	
	@PostMapping("/clientes/guardar")
	public String registrar(@Validated Cliente cliente, BindingResult br, Model modelo) {
		if (br.hasErrors()) {
			modelo.addAttribute("cliente", cliente);
			List<TipoCliente> listaTipos = (List<TipoCliente>) tcr.findAll();
			modelo.addAttribute("tipos", listaTipos);
			return "nuevoCliente";
		}
		
		cr.save(cliente);
		modelo.addAttribute("mensaje","Se guardo correctamente");
		return listar(1,modelo);
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Cliente cliente = cr.findById(id).get();
		modelo.addAttribute("cliente", cliente);
		List<TipoCliente> listaTipos = (List<TipoCliente>) tcr.findAll();
		modelo.addAttribute("tipos", listaTipos);
		return "editarCliente";
	}
	
	@PostMapping("/clientes/editar")
	public String actualizar(@ModelAttribute("cliente") Cliente cliente, BindingResult br,Model modelo) {
		if (br.hasErrors()) {
			modelo.addAttribute("cliente", cliente);
			List<TipoCliente> listaTipos = (List<TipoCliente>) tcr.findAll();
			modelo.addAttribute("tipos", listaTipos);
			return "editarCliente";
		}
		
		Cliente cli = cr.findById(cliente.getId()).get();
		cli.setNombre(cliente.getNombre());
		cli.setCiudad(cliente.getCiudad());
		cli.setCredito(cliente.getCredito());
		cli.setTipo(cliente.getTipo());
		cr.save(cli);
		modelo.addAttribute("mensaje","Se actualizo correctamente");
		return listar(1,modelo);
	}
	
	@GetMapping("/clientes/borrar/{id}")
	public String borrar(@PathVariable  int id, RedirectAttributes ra) {
		cr.deleteById(id);
		ra.addFlashAttribute("mensaje","Se elimino correctamente");
		return "redirect:/clientes";
	}
	
}
