package com.co.pragma.usuario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.pragma.usuario.model.Foto;

@FeignClient(name="servicio-foto", fallback = FotoHystrixFallbackFactory.class)
public interface FotoClient {

	@GetMapping(value = "/foto/{id}")
	public ResponseEntity<Foto> getFotoById(@PathVariable("id") Long id);
	
	@PostMapping(value = "/foto/crear")
	public ResponseEntity<Foto> createcourse(@RequestBody Foto foto);
	
	@DeleteMapping("/foto/eliminar")
	public void eliminarUsuario(@RequestParam(value = "id") Long idUsuario);
	
}
