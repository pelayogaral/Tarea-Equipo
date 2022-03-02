package com.formacionspringboot.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspringboot.apirest.entity.Articulo;
import com.formacionspringboot.apirest.service.ArticuloService;


@RestController
@RequestMapping("/api")
public class ArticuloRestController {

	
	
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping({"/articulos", "/todos"})
	public List<Articulo> index(){
		return articuloService.findAll();
	}
	
//	@GetMapping("clientes/{id}")
//	public Cliente findById(@PathVariable Long id){
//		return clienteService.findById(id);
//	}
	
	@GetMapping("articulos/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Articulo articulo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			articulo = articuloService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al reallizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if(articulo == null) {
			response.put("mensaje", "El articulo ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}

		
		return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
		
	}
	
//	@PostMapping("/cliente")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente saveCliente(@RequestBody Cliente cliente) {
//		return clienteService.save(cliente);
//	}
	
	@PostMapping("/articulo")
	public ResponseEntity<?> saveCliente(@RequestBody Articulo articulo){
		Articulo articuloNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			articuloNuevo = articuloService.save(articulo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El articulo ha sido creado con éxito");
		response.put("articulo", articuloNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
//	@PutMapping("/cliente/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
//		Cliente clienteUpdate = clienteService.findById(id);
//		clienteUpdate.setApellido(cliente.getApellido());
//		clienteUpdate.setNombre(cliente.getNombre());
//		clienteUpdate.setEmail(cliente.getEmail());
//		clienteUpdate.setTelefono(cliente.getTelefono());
//		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
//		
//		return clienteService.save(clienteUpdate);	
//	}
	
	@PutMapping("/articulo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateArticulo(@RequestBody Articulo articulo, @PathVariable Long id) {
		Articulo articuloActual = articuloService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (articuloActual == null) {
			response.put("mensaje", "El articulo ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try{
			articuloActual.setNombre(articulo.getNombre());
			articuloActual.setDescripcion(articulo.getDescripcion());
			articuloActual.setPrecioUnidad(articulo.getPrecioUnidad());
			articuloActual.setUnidadesStock(articulo.getUnidadesStock());
			articuloActual.setStockSeguridad(articulo.getStockSeguridad());
			articuloActual.setImagen(articulo.getImagen());
		
			
			articuloService.save(articuloActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar update");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El articulo ha sido actualizado con éxito");
		response.put("articulo", articuloActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
	}
	
//	@DeleteMapping("/cliente/{id}")
//	@ResponseStatus(HttpStatus.OK)
//	public Cliente deleteCliente(@PathVariable Long id) {
//		Cliente clienteEliminado = findById(id);
//		clienteService.delete(id);
//		
//		return clienteEliminado;
//	}
	
	@DeleteMapping("/articulo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteArticulo(@PathVariable Long id){
		
		Articulo articuloEliminado = articuloService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (articuloEliminado == null) {
			response.put("mensaje", "El articulo ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			articuloService.delete(id);
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el articulo");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El articulo ha sido eliminado con éxito");
		response.put("articulo", articuloEliminado);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}

