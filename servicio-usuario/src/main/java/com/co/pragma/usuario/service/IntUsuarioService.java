package com.co.pragma.usuario.service;

import java.util.List;

import com.co.pragma.usuario.entity.Usuario;

public interface IntUsuarioService {

	public List<Usuario> listAllUsuarios();

	public Usuario getUsuario(Long id);
	
	public Usuario findByTipoIdAndIdUsuario(String tipoId, Long idUsuario);

	public Usuario createUsuario(Usuario usuario);

	public Usuario updateUsuario(Usuario usuario);

	public void deleteUsuario(Long id);
	
}
