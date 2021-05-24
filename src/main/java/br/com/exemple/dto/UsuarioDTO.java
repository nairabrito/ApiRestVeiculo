package br.com.exemple.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import br.com.exemple.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{email.not.blank}")
	@Email(message = "{email.not.valid}")
	private String email;
	
	@NotBlank(message = "{cpf.not.blank}")
	@CPF(message="{cpf.not.valid}")
	private String cpf;
	
	@NotNull(message = "{dataNascimento.not.null}")
	@Temporal(TemporalType.DATE) 
	private Date dataNascimento;
	
	public Usuario transformaParaObjeto() {
		return new Usuario(nome, email, cpf, dataNascimento);
		
	}
}
