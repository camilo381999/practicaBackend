package com.co.pragma.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.pragma.usuario.entity.Usuario;
import com.co.pragma.usuario.service.IntUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private IntUsuarioService intUsuarioService;

	/* metodo para listar a todos los clientes de la base de datos */
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuario() {
		List<Usuario> usuarios = intUsuarioService.listAllUsuarios();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	/* metodo para buscar a un cliente por el tipo y numero de documento */
	@GetMapping("/filtro")
	public ResponseEntity<Usuario> encontarPorTipoIdYidUsuario(@RequestParam(name = "tipoId") String tipoId,
			@RequestParam(name = "numeroId") Long idUsuario) {

		Usuario usuarios = intUsuarioService.findByTipoIdAndIdUsuario(tipoId, idUsuario);
		if (usuarios == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	/* metodo para listar clientes con una edad mayor o igual a n*/
	@GetMapping("/edad")
	public ResponseEntity<List<Usuario>> listarMayorIgualEdad(@RequestParam(name = "edad") int edad) {
		List<Usuario> usuarios = intUsuarioService.findByEdadGreaterThanEqual(edad);
		if (usuarios == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	/* metodo para insertar a un nuevo cliente en la base de datos */
	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCreate = intUsuarioService.createUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreate);
	}

	/* metodo para actualizar los datos de un cliente en la base de datos */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable(value = "id") Long idUsuario,
			@RequestBody Usuario usuario) {
		usuario.setIdUsuario(idUsuario);
		Usuario usuarioDB = intUsuarioService.updateUsuario(usuario);
		if (usuarioDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarioDB);
	}

	@DeleteMapping("/eliminar")
	public void eliminarUsuario(@RequestParam(value = "id") Long idUsuario) {
		intUsuarioService.deleteUsuario(idUsuario);
	}
	
}
