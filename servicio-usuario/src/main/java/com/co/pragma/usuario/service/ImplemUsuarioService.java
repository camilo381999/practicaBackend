package com.co.pragma.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.pragma.usuario.client.FotoClient;
import com.co.pragma.usuario.entity.Usuario;
import com.co.pragma.usuario.model.Foto;
import com.co.pragma.usuario.repository.IntUsuarioRepository;

@Service
public class ImplemUsuarioService implements IntUsuarioService {

	@Autowired
	private IntUsuarioRepository intUsuarioRepository;

	@Autowired
	private FotoClient fotoClient;

	@Override
	public List<Usuario> listAllUsuarios() {
		return intUsuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuario(Long id) {
		Usuario usuario = intUsuarioRepository.findById(id).orElse(null);
		if(usuario!=null) {
			Foto foto =fotoClient.getFotoById(usuario.getIdUsuario()).getBody();
			usuario.setFoto(foto);
		}
		return usuario;
	}

	/*Metodo que consulta por dos parametros tipoId y numeroId}*/
	@Override
	public Usuario findByTipoIdAndIdUsuario(String tipoId, Long idUsuario) {
		Usuario usuarioDB = intUsuarioRepository.findByTipoIdAndIdUsuario(tipoId, idUsuario);
		if (usuarioDB == null) {
			return null;
		}
		Foto foto =fotoClient.getFotoById(usuarioDB.getIdUsuario()).getBody();
		foto.setIdCliente(idUsuario);
		usuarioDB.setFoto(foto);
		return usuarioDB;
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		Foto foto = usuario.getFoto();
		fotoClient.createcourse(foto);
		return intUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Usuario usuarioDB = getUsuario(usuario.getIdUsuario());

		if (usuarioDB == null) {
			return null;
		}
		usuarioDB.setNombres(usuario.getNombres());
		usuarioDB.setApellidos(usuario.getApellidos());
		usuarioDB.setEdad(usuario.getEdad());
		usuarioDB.setTipoId(usuario.getTipoId());
		return intUsuarioRepository.save(usuarioDB);
	}

	@Override
	public void deleteUsuario(Long id) {
		Usuario usuarioDB = getUsuario(id);

		if (usuarioDB != null) {
			fotoClient.eliminarUsuario(id);
			intUsuarioRepository.delete(usuarioDB);
		}
		// usuarioDB.setEdad(0);
		// return intUsuarioRepository.save(usuarioDB);

	}

	@Override
	public List<Usuario> findByEdadGreaterThanEqual(int edad) {
		return intUsuarioRepository.findByEdadGreaterThanEqual(edad);
	}

}
