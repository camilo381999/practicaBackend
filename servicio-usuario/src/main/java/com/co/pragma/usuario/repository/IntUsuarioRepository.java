package com.co.pragma.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.pragma.usuario.entity.Usuario;

public interface IntUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByTipoIdAndIdUsuario(String tipoId, Long idUsuario);
	
	public List<Usuario> findByEdadGreaterThanEqual(int edad);
	
}
