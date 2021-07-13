package com.co.pragma.usuario.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.co.pragma.usuario.model.Foto;

import lombok.Data;

@Entity
@Table(name = "CLIENTE")
@Data
public class Usuario {

	 /* Atributos */
	@Id
	private long idUsuario;
	
	
	private String nombres;
	
	
	private String apellidos;
	
	
	private String tipoId;
	
	
	private int edad;
	
	
	private String ciudadNacimiento;
	
	@Transient
	private Foto foto;
}
