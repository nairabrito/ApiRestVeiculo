package br.com.exemple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemple.error.HttpResponse;
import br.com.exemple.model.Usuario;
import br.com.exemple.model.Veiculo;
import br.com.exemple.service.FipeService;
import br.com.exemple.service.VeiculoService;

@RequestMapping("/veiculos")
@RestController
public class VeiculoController {
	
	private final VeiculoService veiculoService;
	@Autowired
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService  = veiculoService;
	}
	
	@Autowired
    private FipeService fipeService;

	@PostMapping("marcas/{marca}/modelos/{modelos}/anos/{anos}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable("marca") String marca,
											@PathVariable("modelos") String modelos,
											@PathVariable("anos") String anos) {

        Veiculo veiculo = fipeService.infoVeiculo(marca, modelos, anos);
     
        veiculo = veiculoService.salvar(veiculo);
		return new ResponseEntity<>((veiculo), HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/lista")
	public HttpResponse listaVeiculosUsuario(@RequestBody Usuario usuario) {
		try {
			return new HttpResponse(HttpStatus.OK, veiculoService.listaVeiculosUsuario(usuario.getCpf()));
		} catch (Exception ex) {
			return new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na procura");
		}
	}
}
