package com.co.pragma.foto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.pragma.foto.entity.Foto;
import com.co.pragma.foto.service.IntFotoService;

@RestController
@RequestMapping(value = { "/foto" })
public class FotoController {

	@Autowired
	private IntFotoService intFotoService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Foto> getFotoById(@PathVariable(name="id") Long id) {
		System.out.println(id);
		Optional<Foto> optFoto = intFotoService.findById(id);
		Foto foto = optFoto.get();
		if (foto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(foto);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Foto> createcourse(@RequestBody Foto foto) {
		Foto fotoCreate = intFotoService.createFoto(foto);
		return ResponseEntity.status(HttpStatus.CREATED).body(fotoCreate);
	}

}
