package com.co.pragma.foto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.pragma.foto.entity.Foto;
import com.co.pragma.foto.repository.IntFotoRepository;

@Service
@Transactional
public class ImplemFotoService implements IntFotoService{

	@Autowired
	private IntFotoRepository intFotoRepository;
	
	@Override
	public List<Foto> getFoto() {
		return (List<Foto> ) intFotoRepository.findAll();
	}

	@Override
	public Foto createFoto(Foto foto) {
		return intFotoRepository.save(foto);
	}

	@Override
	public Optional<Foto> findById(Long id) {
		return intFotoRepository.findById(id);
	}

	@Override
	public Foto update(Foto foto, Long id) {
		return intFotoRepository.save(foto);
	}

	@Override
	public void deleteFotoById(long id) {
		intFotoRepository.deleteById(id);
	}

	@Override
	public Foto updatePartially(Foto foto, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
