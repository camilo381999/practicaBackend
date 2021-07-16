package com.co.pragma.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foto {
	
	/*private String id;*/

	private String foto;
	
	private Long idCliente;

}
