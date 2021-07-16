package com.co.pragma.usuario.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.co.pragma.usuario.model.Foto;

@Component
public class FotoHystrixFallbackFactory implements FotoClient{

	@Override
	public ResponseEntity<Foto> getFotoById(Long id) {
		Foto foto = Foto.builder().idCliente(null).foto("none").build();
		return ResponseEntity.ok(foto);
	}

	@Override
	public ResponseEntity<Foto> createcourse(Foto foto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		
	}

}
