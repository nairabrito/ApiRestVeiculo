package br.com.exemple.dto;

import java.util.Date;

import br.com.exemple.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRetornoDTO {

	private Long idUsuario;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	
	public static UsuarioRetornoDTO transformaEmDTO(Usuario usuario) {
		return new UsuarioRetornoDTO(usuario.getIdUsuario(), 
										usuario.getNome(), 
										usuario.getEmail(), 
										usuario.getCpf(), 
										usuario.getDataNascimento());
		
	}
}
