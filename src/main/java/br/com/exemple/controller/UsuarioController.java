package br.com.exemple.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.exemple.dto.UsuarioDTO;
import br.com.exemple.dto.UsuarioRetornoDTO;
import br.com.exemple.model.Usuario;
import br.com.exemple.service.UsuarioService;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService  = usuarioService;
	}
	
	@PostMapping
	public ResponseEntity<UsuarioRetornoDTO> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.salvar(usuarioDTO.transformaParaObjeto());
		return new ResponseEntity<>(UsuarioRetornoDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
	}

}
