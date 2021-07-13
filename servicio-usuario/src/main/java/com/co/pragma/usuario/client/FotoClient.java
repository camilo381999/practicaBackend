package com.co.pragma.usuario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.pragma.usuario.model.Foto;

@FeignClient(name="servicio-foto")
@RequestMapping(value = { "/foto" })
public interface FotoClient {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Foto> getFotoById(@PathVariable("id") Long id);
	
}
