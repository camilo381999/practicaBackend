package com.co.pragma.foto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document(collection = "FOTOS")
@Data
public class Foto {

	@Id
	@Field("id")
	@JsonIgnore
	private String id;

	private String foto;

}
