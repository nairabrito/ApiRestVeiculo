package br.com.exemple.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.exemple.model.Veiculo;

@FeignClient(url= "https://parallelum.com.br/fipe/api/v1/carros/" , name = "fipe")
public interface FipeService {

	@GetMapping("marcas/{marca}/modelos/{modelos}/anos/{anos}")
	public Veiculo infoVeiculo(@PathVariable("marca") String marca,
											@PathVariable("modelos") String modelos,
											@PathVariable("anos") String anos);


	
	
	
}
