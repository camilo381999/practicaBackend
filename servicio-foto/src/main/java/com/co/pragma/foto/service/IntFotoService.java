package com.co.pragma.foto.service;

import java.util.List;
import java.util.Optional;

import com.co.pragma.foto.entity.Foto;

public interface IntFotoService {

	public List<Foto> getFoto();

	public Foto createFoto(Foto foto);
	
	public Optional<Foto> findByIdCliente(Long id);

	public Foto update(Foto foto, Long id);

	public void deleteFotoById(Long id);

}
